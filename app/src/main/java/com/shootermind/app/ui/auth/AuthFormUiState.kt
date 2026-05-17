package com.shootermind.app.ui.auth

data class AuthFormUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val hasEmptyFieldsError: Boolean = false,
    val isSignedIn: Boolean = false
)
