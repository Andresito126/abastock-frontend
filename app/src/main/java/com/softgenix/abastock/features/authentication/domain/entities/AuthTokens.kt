package com.softgenix.abastock.features.authentication.domain.entities

data class AuthTokens(
    val accessToken: String,
    val refreshToken: String
)