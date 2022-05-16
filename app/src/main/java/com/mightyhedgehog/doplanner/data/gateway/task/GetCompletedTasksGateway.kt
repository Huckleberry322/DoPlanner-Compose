package com.mightyhedgehog.doplanner.data.gateway.task

import com.mightyhedgehog.doplanner.data.local.json.task.CompletedTaskStorage
import com.mightyhedgehog.doplanner.data.mapper.task.toTask
import javax.inject.Inject

class GetCompletedTasksGateway @Inject constructor(
    private val taskStorage: CompletedTaskStorage
) {
    suspend fun execute() = taskStorage.get().map { it.toTask() }
}
