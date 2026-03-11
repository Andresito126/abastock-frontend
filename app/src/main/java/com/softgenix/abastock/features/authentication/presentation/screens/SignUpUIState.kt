package com.softgenix.abastock.features.authentication.presentation.screens

data class SignUpUIState (
    val storeName: String = "",
    val name: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val passwordVisible: Boolean = false,
    val confirmPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false,
    val isAuthenticated: Boolean = false
){
    val passwordsMatch: Boolean
        get() = confirmPassword.isEmpty() || password == confirmPassword

    val isFormValid: Boolean
        get() = storeName.isNotBlank()
                && name.isNotBlank()
                && lastName.isNotBlank()
                && phoneNumber.isNotBlank()
                && email.isNotBlank()
                && password.isNotBlank()
                && passwordsMatch
}