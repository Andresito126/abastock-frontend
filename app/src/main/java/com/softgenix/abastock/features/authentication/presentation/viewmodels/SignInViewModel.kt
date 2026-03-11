package com.softgenix.abastock.features.authentication.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softgenix.abastock.core.data.local.TokenManager
import com.softgenix.abastock.features.authentication.domain.entities.LoginCredentials
import com.softgenix.abastock.features.authentication.domain.usecases.LoginUseCase
import com.softgenix.abastock.features.authentication.presentation.screens.SignInUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val tokenManager: TokenManager
) : ViewModel() {

    private val _state = MutableStateFlow(SignInUIState())
    val state = _state.asStateFlow()

    fun onCredentialChange(value: String) = _state.update { it.copy(credential = value) }
    fun onPasswordChange(value: String) = _state.update { it.copy(password = value) }
    fun onTogglePasswordVisible() = _state.update { it.copy(passwordVisible = !it.passwordVisible) }

    fun onSignIn() {
        val current = _state.value
        if (!current.isFormValid) return

        val credentials = if (current.credential.contains("@")) {
            LoginCredentials(email = current.credential, password = current.password)
        } else {
            LoginCredentials(phoneNumber = current.credential, password = current.password)
        }

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            loginUseCase(credentials)
                .onSuccess { tokens ->
                    tokenManager.saveTokens(tokens.accessToken, tokens.refreshToken)
                    _state.update { it.copy(isLoading = false, isAuthenticated = true) }
                }
                .onFailure { e ->
                    _state.update { it.copy(isLoading = false, error = e.message) }
                }
        }
    }
}
