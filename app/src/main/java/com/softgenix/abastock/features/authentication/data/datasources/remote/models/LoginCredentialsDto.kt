package com.softgenix.abastock.features.authentication.data.datasources.remote.models

import com.google.gson.annotations.SerializedName

data class LoginCredentialsDto(
    @SerializedName("email") val email: String? = null,
    @SerializedName("phoneNumber") val phoneNumber: String? = null,
    @SerializedName("password") val password: String
)