package com.mightyhedgehog.doplanner.domain.usecase.task

import com.mightyhedgehog.doplanner.data.local.json.task.CompletedTaskStorage
import com.mightyhedgehog.doplanner.data.mapper.task.toJsonTask
import com.mightyhedgehog.doplanner.domain.model.task.Task
import com.mightyhedgehog.doplanner.ext.findAndRemove
import javax.inject.Inject

class DeleteCompletedTaskUseCase @Inject constructor(
    private val completedTaskStorage: CompletedTaskStorage,
) {
    suspend fun execute(task: Task) {
        val jsonTask = task.toJsonTask()
        val currentStorageList = completedTaskStorage.get()
        val newList = currentStorageList.toMutableList().findAndRemove(jsonTask)
        completedTaskStorage.update(newList)
    }
}
