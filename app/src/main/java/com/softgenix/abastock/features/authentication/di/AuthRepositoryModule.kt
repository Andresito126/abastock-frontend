package com.softgenix.abastock.features.authentication.di

import com.softgenix.abastock.features.authentication.data.datasources.remote.repositories.AuthRepositoryImpl
import com.softgenix.abastock.features.authentication.domain.repositories.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PostsRepositoryModule {
    @Binds
    abstract fun bindAuthRepository(
        postsRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
}