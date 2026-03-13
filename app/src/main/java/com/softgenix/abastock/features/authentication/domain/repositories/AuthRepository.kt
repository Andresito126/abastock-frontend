package com.softgenix.abastock.features.authentication.domain.repositories

import com.softgenix.abastock.features.authentication.domain.entities.AuthTokens
import com.softgenix.abastock.features.authentication.domain.entities.LoginCredentials
import com.softgenix.abastock.features.authentication.domain.entities.RegisterUser

interface AuthRepository {
    suspend fun registerUser(user: RegisterUser): Result<Unit>
    suspend fun login(credentials: LoginCredentials): AuthTokens

}