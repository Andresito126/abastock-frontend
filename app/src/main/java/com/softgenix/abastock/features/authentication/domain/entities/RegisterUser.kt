package com.softgenix.abastock.features.authentication.domain.entities

data class RegisterUser (
    val id: String,
    val firstName: String,
    val middleName: String,
    val firstSurname: String,
    val secondLastName: String,
    val phoneNumber: String,
    val email: String,
    val password: String
)