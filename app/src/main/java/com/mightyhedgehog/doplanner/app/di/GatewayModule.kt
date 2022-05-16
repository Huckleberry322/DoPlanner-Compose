package com.mightyhedgehog.doplanner.app.di

import com.mightyhedgehog.doplanner.data.local.json.task.CompletedTaskStorage
import com.mightyhedgehog.doplanner.data.local.json.task.TaskStorage
import com.mightyhedgehog.doplanner.data.gateway.task.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object GatewayModule {

    @Provides
    fun provideGetTasksUseCase(taskStorage: TaskStorage): GetTasksGateway {
        return GetTasksGateway(taskStorage = taskStorage)
    }

    @Provides
    fun provideDeleteTaskUseCase(taskStorage: TaskStorage): DeleteTaskGateway {
        return DeleteTaskGateway(taskStorage = taskStorage)
    }

    @Provides
    fun provideAddTaskUseCase(taskStorage: TaskStorage): AddTaskGateway {
        return AddTaskGateway(taskStorage = taskStorage)
    }

    @Provides
    fun provideGetCompletedTasksUseCase(completedTaskStorage: CompletedTaskStorage): GetCompletedTasksGateway {
        return GetCompletedTasksGateway(taskStorage = completedTaskStorage)
    }

    @Provides
    fun provideDeleteCompletedTaskUseCase(completedTaskStorage: CompletedTaskStorage): DeleteCompletedTaskGateway {
        return DeleteCompletedTaskGateway(completedTaskStorage = completedTaskStorage)
    }

    @Provides
    fun provideCompleteTaskUseCase(
        taskStorage: TaskStorage, completedTaskStorage: CompletedTaskStorage
    ): CompleteTaskGateway {
        return CompleteTaskGateway(
            taskStorage = taskStorage, completedTaskStorage = completedTaskStorage
        )
    }
}
