package com.softgenix.abastock.features.inventory.data.datasources.remote.api


import com.softgenix.abastock.features.inventory.data.datasources.remote.models.InventoryResponse
import com.softgenix.abastock.features.inventory.data.datasources.remote.models.InventoryScanResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InventoryApi {
    @GET("inventory/store/{storeId}")
    suspend fun getInventory(
        @Path("storeId") storeId: String
    ): InventoryResponse

    @GET("inventory/store/{storeId}/search")
    suspend fun searchInventory(
        @Path("storeId") storeId: String,
        @Query("q") query: String
    ): InventoryResponse

    @GET("inventories/scan")
    suspend fun scanProduct(
        @Query("storeId") storeId: String,
        @Query("barcode") barcode: String
    ): InventoryScanResponse
}