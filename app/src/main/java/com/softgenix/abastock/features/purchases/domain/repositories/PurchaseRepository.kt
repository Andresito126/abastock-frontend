package com.softgenix.abastock.features.purchases.domain.repositories

import com.softgenix.abastock.features.purchases.domain.entities.Purchase
import com.softgenix.abastock.features.purchases.domain.entities.PurchaseItem

interface PurchaseRepository {

    suspend fun getProductByBarcode(barcode: String): Result<PurchaseItem?>

    suspend fun savePurchase(purchase: Purchase): Result<Unit>
}