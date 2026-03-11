package com.softgenix.abastock.features.inventory.data.datasources.remote.models

data class InventoryDto(
    val inventoryId: String,
    val presentationId: String,
    val productName: String,
    val brandName: String,
    val categoryName: String,
    val currentStock: Double,
    val minStockAlert: Double,
    val salePrice: Double,
    val unit: String,
    val value: Double,
    val barcode: String
)

data class InventoryResponse(
    val success: Boolean,
    val message: String,
    val data: List<InventoryDto>
)