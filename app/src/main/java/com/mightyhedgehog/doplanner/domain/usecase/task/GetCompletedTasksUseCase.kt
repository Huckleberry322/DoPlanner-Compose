package com.mightyhedgehog.doplanner.domain.usecase.task

import com.mightyhedgehog.doplanner.data.local.json.task.CompletedTaskStorage
import com.mightyhedgehog.doplanner.data.mapper.task.toTask
import javax.inject.Inject

class GetCompletedTasksUseCase @Inject constructor(
    private val taskStorage: CompletedTaskStorage
) {
    suspend fun execute() = taskStorage.get().map { it.toTask() }
}
