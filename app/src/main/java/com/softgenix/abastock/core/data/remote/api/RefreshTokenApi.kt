package com.softgenix.abastock.core.data.remote.api

import com.softgenix.abastock.core.data.remote.models.RefreshTokenRequestDto
import com.softgenix.abastock.core.data.remote.models.RefreshTokenResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface RefreshTokenApi {
    @POST("auth/refresh-token")
    suspend fun refresh(@Body request: RefreshTokenRequestDto): RefreshTokenResponseDto
}