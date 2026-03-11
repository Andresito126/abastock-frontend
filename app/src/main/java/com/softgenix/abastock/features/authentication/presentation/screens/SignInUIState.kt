package com.softgenix.abastock.features.authentication.presentation.screens

data class SignInUIState(
    val credential: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isAuthenticated: Boolean = false
)