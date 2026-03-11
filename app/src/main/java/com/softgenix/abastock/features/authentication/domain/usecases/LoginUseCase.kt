package com.softgenix.abastock.features.authentication.domain.usecases

import com.softgenix.abastock.features.authentication.domain.entities.AuthTokens
import com.softgenix.abastock.features.authentication.domain.entities.LoginCredentials
import com.softgenix.abastock.features.authentication.domain.repositories.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(credentials: LoginCredentials): Result<AuthTokens> {
        return runCatching {
            repository.login(credentials)
        }
    }
}