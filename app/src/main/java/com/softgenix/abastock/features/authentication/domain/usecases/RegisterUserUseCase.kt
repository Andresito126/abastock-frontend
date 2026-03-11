package com.softgenix.abastock.features.authentication.domain.usecases

import com.softgenix.abastock.features.authentication.domain.entities.RegisterUser
import com.softgenix.abastock.features.authentication.domain.repositories.AuthRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(user: RegisterUser): Result<Unit> {
        return repository.registerUser(user)
    }
}