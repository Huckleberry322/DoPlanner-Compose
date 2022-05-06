package com.mightyhedgehog.doplanner.app.di

import com.mightyhedgehog.doplanner.presentation.screen.daily.DailyUpdateHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HandlerModule {

    @Provides
    @Singleton
    fun provideDailyUpdateHandler() = DailyUpdateHandler()
}
