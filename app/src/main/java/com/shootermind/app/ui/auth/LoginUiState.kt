package com.shootermind.app.ui.auth

data class LoginUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isSignedIn: Boolean = false
)
