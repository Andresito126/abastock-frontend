package com.softgenix.abastock.core.hardware.di

import com.softgenix.abastock.core.hardware.data.AndroidVoiceManager
import com.softgenix.abastock.core.hardware.domain.VoiceManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HardwareModule {
    @Binds
    @Singleton
    abstract fun bindVoiceManager(impl: AndroidVoiceManager): VoiceManager
}