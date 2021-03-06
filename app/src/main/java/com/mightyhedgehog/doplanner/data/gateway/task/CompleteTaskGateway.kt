package com.mightyhedgehog.doplanner.data.gateway.task

import com.mightyhedgehog.doplanner.data.local.json.task.CompletedTaskStorage
import com.mightyhedgehog.doplanner.data.local.json.task.TaskStorage
import com.mightyhedgehog.doplanner.data.mapper.task.toJsonTask
import com.mightyhedgehog.doplanner.presentation.model.task.Task
import com.mightyhedgehog.doplanner.ext.findAndRemove
import javax.inject.Inject

class CompleteTaskGateway @Inject constructor(
    private val taskStorage: TaskStorage,
    private val completedTaskStorage: CompletedTaskStorage
) {
    suspend fun execute(task: Task) {
        val taskList = taskStorage.get()
        val completedTaskList = completedTaskStorage.get()

        val jsonTask = task.toJsonTask()

        val newTaskList = taskList.toMutableList().findAndRemove(jsonTask)
        val newCompletedList = completedTaskList.toMutableList().apply {
            add(jsonTask)
        }

        taskStorage.update(newTaskList)
        completedTaskStorage.update(newCompletedList)
    }
}
