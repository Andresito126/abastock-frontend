package com.softgenix.abastock.features.authentication.domain.entities

data class LoginCredentials(
    val email: String? = null,
    val phoneNumber: String? = null,
    val password: String
)