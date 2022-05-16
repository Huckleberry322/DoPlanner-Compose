package com.mightyhedgehog.doplanner.data.gateway.task

import com.mightyhedgehog.doplanner.data.local.json.task.TaskStorage
import com.mightyhedgehog.doplanner.data.mapper.task.toTask
import com.mightyhedgehog.doplanner.presentation.model.task.Task
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetTasksGateway @Inject constructor(
    private val taskStorage: TaskStorage
) {
    suspend fun execute() : List<Task> {
        delay(2000)
        return taskStorage.get().map { it.toTask() }
    }
}
