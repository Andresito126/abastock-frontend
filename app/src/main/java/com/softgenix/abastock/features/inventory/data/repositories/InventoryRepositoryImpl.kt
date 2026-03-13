package com.softgenix.abastock.features.inventory.data.repositories

import com.softgenix.abastock.features.inventory.data.datasources.remote.api.InventoryApi
import com.softgenix.abastock.features.inventory.data.datasources.remote.mapper.toDomain
import com.softgenix.abastock.features.inventory.domain.entities.InventoryItem
import com.softgenix.abastock.features.inventory.domain.repositories.InventoryRepository
import com.softgenix.abastock.features.inventory.domain.entities.ScannedProduct

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

    override suspend fun scanProduct(storeId: String, barcode: String): Result<ScannedProduct?> {
        android.util.Log.d("SCANNER_REPO", "Iniciando petición -> storeId: $storeId, barcode: $barcode")

        return try {
            val response = api.scanProduct(storeId, barcode)

            android.util.Log.d("SCANNER_REPO", "Respuesta Exitosa (200 OK): $response")

            val domainProduct = response.toDomain()
            android.util.Log.d("SCANNER_REPO", "Mapeo exitoso: $domainProduct")

            Result.success(domainProduct)

        } catch (e: retrofit2.HttpException) {
            val code = e.code()
            val errorBody = e.response()?.errorBody()?.string()
            android.util.Log.e("SCANNER_REPO", "Error HTTP $code: $errorBody")

            if (code == 404) Result.success(null)
            else Result.failure(e)

        } catch (e: Exception) {
            android.util.Log.e("SCANNER_REPO", "EXCEPCIÓN CRÍTICA: ${e.message}")
            e.printStackTrace()
            Result.failure(e)
        }
    }
}