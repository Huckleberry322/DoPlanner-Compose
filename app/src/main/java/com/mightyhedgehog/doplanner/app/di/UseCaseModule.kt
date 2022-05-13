package com.mightyhedgehog.doplanner.app.di

import com.mightyhedgehog.doplanner.data.local.json.task.CompletedTaskStorage
import com.mightyhedgehog.doplanner.data.local.json.task.TaskStorage
import com.mightyhedgehog.doplanner.domain.usecase.task.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetTasksUseCase(taskStorage: TaskStorage): GetTasksUseCase {
        return GetTasksUseCase(taskStorage = taskStorage)
    }

    @Provides
    fun provideDeleteTaskUseCase(taskStorage: TaskStorage): DeleteTaskUseCase {
        return DeleteTaskUseCase(taskStorage = taskStorage)
    }

    @Provides
    fun provideAddTaskUseCase(taskStorage: TaskStorage): AddTaskUseCase {
        return AddTaskUseCase(taskStorage = taskStorage)
    }

    @Provides
    fun provideGetCompletedTasksUseCase(completedTaskStorage: CompletedTaskStorage): GetCompletedTasksUseCase {
        return GetCompletedTasksUseCase(taskStorage = completedTaskStorage)
    }

    @Provides
    fun provideDeleteCompletedTaskUseCase(completedTaskStorage: CompletedTaskStorage): DeleteCompletedTaskUseCase {
        return DeleteCompletedTaskUseCase(completedTaskStorage = completedTaskStorage)
    }

    @Provides
    fun provideCompleteTaskUseCase(
        taskStorage: TaskStorage, completedTaskStorage: CompletedTaskStorage
    ): CompleteTaskUseCase {
        return CompleteTaskUseCase(
            taskStorage = taskStorage, completedTaskStorage = completedTaskStorage
        )
    }
}
