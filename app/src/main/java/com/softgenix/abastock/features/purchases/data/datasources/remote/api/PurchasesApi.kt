package com.softgenix.abastock.features.purchases.data.datasources.remote.api

import com.softgenix.abastock.features.purchases.data.datasources.remote.models.AbastockResponse
import com.softgenix.abastock.features.purchases.data.datasources.remote.models.ProductDto
import com.softgenix.abastock.features.purchases.data.datasources.remote.models.PurchaseRequestDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PurchasesApi {
    @GET("products/barcode/{barcode}")
    suspend fun getProductByBarcode(@Path("barcode") barcode: String): AbastockResponse<ProductDto>

    @POST("purchases")
    suspend fun savePurchase(@Body purchaseRequest: PurchaseRequestDto): AbastockResponse<Unit>
}