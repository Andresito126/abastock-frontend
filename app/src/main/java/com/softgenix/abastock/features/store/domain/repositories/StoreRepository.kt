package com.softgenix.abastock.features.store.domain.repositories

import com.softgenix.abastock.features.store.domain.entities.Store

interface StoreRepository {
    suspend fun createStore(store: Store): Result<Unit>
}