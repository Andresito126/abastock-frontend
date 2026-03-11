package com.softgenix.abastock.features.inventory.data.datasources.remote.mapper

import com.softgenix.abastock.features.inventory.data.datasources.remote.models.InventoryDto
import com.softgenix.abastock.features.inventory.domain.entities.InventoryItem

fun InventoryDto.toDomain(): InventoryItem {
    return InventoryItem(
        inventoryId = this.inventoryId,
        presentationId = this.presentationId,
        productName = this.productName,
        brandName = this.brandName,
        categoryName = this.categoryName,
        currentStock = this.currentStock,
        minStockAlert = this.minStockAlert,
        salePrice = this.salePrice,
        unit = this.unit,
        value = this.value,
        barcode = this.barcode
    )
}