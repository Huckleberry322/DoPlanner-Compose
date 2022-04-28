package com.mightyhedgehog.doplanner.domain.usecase.task

import com.mightyhedgehog.doplanner.data.local.json.task.TaskStorage
import com.mightyhedgehog.doplanner.data.mapper.task.toTask
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(
    private val taskStorage: TaskStorage
) {
    suspend fun execute() = taskStorage.get().map { it.toTask() }
}
