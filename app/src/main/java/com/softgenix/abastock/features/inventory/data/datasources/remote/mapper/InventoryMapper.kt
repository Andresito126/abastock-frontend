package com.softgenix.abastock.features.inventory.data.datasources.remote.mapper

import com.softgenix.abastock.features.inventory.data.datasources.remote.models.InventoryDto
import com.softgenix.abastock.features.inventory.data.datasources.remote.models.InventoryScanResponse
import com.softgenix.abastock.features.inventory.domain.entities.InventoryItem
import com.softgenix.abastock.features.inventory.domain.entities.ScannedProduct

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

fun InventoryScanResponse.toDomain(): ScannedProduct {
    return ScannedProduct(
        id = this.inventory_id,
        productName = this.product_name,
        brandName = this.brand_name,
        categoryName = this.category_name,
        stock = this.current_stock.toDoubleOrNull() ?: 0.0,
        imageUrl = this.image_uri,
        barcode = this.barcode,
        unit = this.unit,
        value = this.value.toDoubleOrNull() ?: 0.0
    )
}