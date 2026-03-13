package com.softgenix.abastock.features.inventory.domain.repositories

import com.softgenix.abastock.features.inventory.domain.entities.InventoryItem
import com.softgenix.abastock.features.inventory.domain.entities.ScannedProduct

interface InventoryRepository {
    suspend fun getInventory(storeId: String): Result<List<InventoryItem>>

    suspend fun searchInventory(storeId: String, query: String): Result<List<InventoryItem>>
    suspend fun scanProduct(storeId: String, barcode: String): Result<ScannedProduct?>
}