package com.softgenix.abastock.core.data.remote.models

data class RefreshTokenRequestDto(
    val refreshToken: String
)

data class RefreshTokenResponseDto(
    val accessToken: String,
    val newRefreshToken: String
)