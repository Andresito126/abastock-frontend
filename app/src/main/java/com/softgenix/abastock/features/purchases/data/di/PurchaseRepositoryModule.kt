package com.softgenix.abastock.features.purchases.data.di

import com.softgenix.abastock.features.purchases.data.repositories.PurchaseRepositoryImpl
import com.softgenix.abastock.features.purchases.domain.repositories.PurchaseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PurchasesRepositoryModule {
    @Binds
    abstract fun bindPurchaseRepository(
        impl: PurchaseRepositoryImpl
    ): PurchaseRepository
}
