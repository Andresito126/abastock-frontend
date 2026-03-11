package com.softgenix.abastock.features.inventory.domain.repositories

import com.softgenix.abastock.features.inventory.domain.entities.InventoryItem

interface InventoryRepository {
    suspend fun getInventory(storeId: String): Result<List<InventoryItem>>

    suspend fun searchInventory(storeId: String, query: String): Result<List<InventoryItem>>
}