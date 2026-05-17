package com.shootermind.app.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shootermind.app.data.auth.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EmailLoginViewModel(
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {
    private val _uiState = MutableStateFlow(AuthFormUiState())
    val uiState: StateFlow<AuthFormUiState> = _uiState.asStateFlow()

    fun onEmailChange(email: String) {
        _uiState.update {
            it.copy(
                email = email,
                errorMessage = null,
                hasEmptyFieldsError = false
            )
        }
    }

    fun onPasswordChange(password: String) {
        _uiState.update {
            it.copy(
                password = password,
                errorMessage = null,
                hasEmptyFieldsError = false
            )
        }
    }

    fun signIn() {
        val currentState = _uiState.value
        if (currentState.isLoading) return
        if (currentState.email.isBlank() || currentState.password.isBlank()) {
            _uiState.update {
                it.copy(
                    errorMessage = null,
                    hasEmptyFieldsError = true
                )
            }
            return
        }

        _uiState.update {
            it.copy(
                isLoading = true,
                errorMessage = null,
                hasEmptyFieldsError = false
            )
        }

        viewModelScope.launch {
            val result = authRepository.signInWithEmail(
                email = currentState.email.trim(),
                password = currentState.password
            )

            _uiState.update {
                if (result.isSuccess) {
                    it.copy(isLoading = false, isSignedIn = true)
                } else {
                    it.copy(
                        isLoading = false,
                        errorMessage = result.exceptionOrNull()?.localizedMessage
                    )
                }
            }
        }
    }

    fun onNavigationHandled() {
        _uiState.update { it.copy(isSignedIn = false) }
    }
}
