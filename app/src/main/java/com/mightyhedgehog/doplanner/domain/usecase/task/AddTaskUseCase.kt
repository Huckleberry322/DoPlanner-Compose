package com.mightyhedgehog.doplanner.domain.usecase.task

import com.mightyhedgehog.doplanner.data.local.json.task.TaskStorage
import com.mightyhedgehog.doplanner.data.mapper.task.toJsonTask
import com.mightyhedgehog.doplanner.domain.model.task.Task
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(
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
