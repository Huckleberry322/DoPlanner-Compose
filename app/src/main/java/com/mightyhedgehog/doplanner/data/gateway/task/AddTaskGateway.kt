package com.mightyhedgehog.doplanner.data.gateway.task

import com.mightyhedgehog.doplanner.data.local.json.task.TaskStorage
import com.mightyhedgehog.doplanner.data.mapper.task.toJsonTask
import com.mightyhedgehog.doplanner.presentation.model.task.Task
import javax.inject.Inject

class AddTaskGateway @Inject constructor(
    private val taskStorage: TaskStorage
) {
    suspend fun execute(task: Task) {
        val jsonTask = task.toJsonTask()
        val newList = taskStorage.get().toMutableList().apply {
            add(jsonTask)
        }
        taskStorage.update(newList)
    }
}
