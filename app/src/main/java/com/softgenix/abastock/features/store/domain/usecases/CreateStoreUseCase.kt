package com.softgenix.abastock.features.store.domain.usecases

import com.softgenix.abastock.features.store.domain.entities.Store
import com.softgenix.abastock.features.store.domain.repositories.StoreRepository
import javax.inject.Inject

class CreateStoreUseCase @Inject constructor(
    private val repository: StoreRepository
) {
    suspend operator fun invoke(store: Store): Result<Unit> {
        return repository.createStore(store)
    }
}