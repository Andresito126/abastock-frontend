package com.softgenix.abastock.features.store.data.datasources.remote.repositories

import com.softgenix.abastock.features.store.data.datasources.remote.api.StoreApi
import com.softgenix.abastock.features.store.domain.entities.Store
import com.softgenix.abastock.features.store.domain.repositories.StoreRepository
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val api: StoreApi
) : StoreRepository {
    override suspend fun createStore(store: Store): Result<Unit> {
        return runCatching {
            api.createStore(store)
        }
    }
}