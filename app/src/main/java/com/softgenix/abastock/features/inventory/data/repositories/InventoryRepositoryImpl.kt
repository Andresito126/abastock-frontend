package com.softgenix.abastock.features.inventory.data.repositories

import com.softgenix.abastock.features.inventory.data.datasources.remote.api.InventoryApi
import com.softgenix.abastock.features.inventory.data.datasources.remote.mapper.toDomain
import com.softgenix.abastock.features.inventory.domain.entities.InventoryItem
import com.softgenix.abastock.features.inventory.domain.repositories.InventoryRepository
import javax.inject.Inject

class InventoryRepositoryImpl @Inject constructor(
    private val api: InventoryApi
) : InventoryRepository {

    override suspend fun getInventory(storeId: String): Result<List<InventoryItem>> {
        return try {
            val response = api.getInventory(storeId)
            if (response.success) {
                Result.success(response.data.map { it.toDomain() })
            } else {
                Result.failure(Exception(response.message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun searchInventory(storeId: String, query: String): Result<List<InventoryItem>> {
        return try {
            val response = api.searchInventory(storeId, query)
            if (response.success) {
                Result.success(response.data.map { it.toDomain() })
            } else {
                Result.failure(Exception(response.message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}