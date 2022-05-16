package com.mightyhedgehog.doplanner.app.di

import android.content.Context
import com.mightyhedgehog.doplanner.data.local.datastore.ThemeDataStore
import com.mightyhedgehog.doplanner.data.local.datastore.themeDataStore
import com.mightyhedgehog.doplanner.data.local.json.task.CompletedTaskStorage
import com.mightyhedgehog.doplanner.data.local.json.task.TaskStorage
import com.mightyhedgehog.doplanner.data.local.json.user.UserStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    private const val TASK_STORAGE_FILENAME = "tasks.json"
    private const val COMPLETED_TASK_STORAGE_FILENAME = "complete_tasks.json"
    private const val USER_STORAGE_FILENAME = "user.json"

    @Provides
    @Singleton
    fun provideTaskStorage(@ApplicationContext context: Context) = TaskStorage(
        storageDirectory = context.cacheDir.toString(),
        fileName = TASK_STORAGE_FILENAME,
    )

    @Provides
    @Singleton
    fun provideCompletedTaskStorage(@ApplicationContext context: Context) = CompletedTaskStorage(
        storageDirectory = context.cacheDir.toString(),
        fileName = COMPLETED_TASK_STORAGE_FILENAME,
    )

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context) = UserStorage(
        storageDirectory = context.cacheDir.toString(),
        fileName = USER_STORAGE_FILENAME,
    )

    @Provides
    @Singleton
    fun provideThemeDataStore(@ApplicationContext context: Context) = ThemeDataStore(
        dataStore = context.themeDataStore
    )
}
