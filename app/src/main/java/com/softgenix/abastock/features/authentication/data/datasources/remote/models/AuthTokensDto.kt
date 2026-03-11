package com.softgenix.abastock.features.authentication.data.datasources.remote.models

import com.google.gson.annotations.SerializedName

data class AuthTokensDto(
    @SerializedName("Token") val token: TokenBodyDto
)

data class TokenBodyDto(
    val accessToken: String,
    val refreshToken: String
)