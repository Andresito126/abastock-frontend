package com.softgenix.abastock.features.store.di

import com.softgenix.abastock.features.store.data.datasources.remote.repositories.StoreRepositoryImpl
import com.softgenix.abastock.features.store.domain.repositories.StoreRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StoreRepositoryModule {
    @Binds
    abstract fun bindStoreRepository(
        storeRepositoryImpl: StoreRepositoryImpl
    ): StoreRepository
}