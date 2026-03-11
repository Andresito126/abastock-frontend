package com.softgenix.abastock.features.purchases.data.repositories

import com.softgenix.abastock.features.purchases.data.datasources.remote.api.PurchasesApi
import com.softgenix.abastock.features.purchases.data.datasources.remote.mapper.toDomain
import com.softgenix.abastock.features.purchases.data.datasources.remote.mapper.toDto
import com.softgenix.abastock.features.purchases.domain.repositories.PurchaseRepository
import com.softgenix.abastock.features.purchases.domain.entities.PurchaseItem
import javax.inject.Inject


import com.softgenix.abastock.features.purchases.domain.entities.Purchase

class PurchaseRepositoryImpl @Inject constructor(
    private val api: PurchasesApi
) : PurchaseRepository {

    override suspend fun getProductByBarcode(barcode: String): Result<PurchaseItem?> {
        return try {
            val response = api.getProductByBarcode(barcode)
            if (response.success) {
                Result.success(response.data.toDomain().copy(barcode = barcode))
            } else {
                Result.success(null)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun savePurchase(purchase: Purchase): Result<Unit> {
        return try {
            val response = api.savePurchase(purchase.toDto())
            if (response.success) Result.success(Unit)
            else Result.failure(Exception(response.message))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}