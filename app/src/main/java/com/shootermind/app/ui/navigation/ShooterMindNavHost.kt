package com.shootermind.app.ui.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shootermind.app.ui.auth.EmailLoginScreen
import com.shootermind.app.ui.auth.EmailLoginViewModel
import com.shootermind.app.ui.auth.LoginScreen
import com.shootermind.app.ui.auth.LoginViewModel
import com.shootermind.app.ui.auth.RegisterViewModel
import com.shootermind.app.ui.auth.RegisterScreen
import com.shootermind.app.ui.home.HomeScreen

@Composable
fun ShooterMindNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        modifier = modifier
    ) {
        composable(Screen.Login.route) {
            val loginViewModel: LoginViewModel = viewModel()
            val loginUiState by loginViewModel.uiState.collectAsStateWithLifecycle()

            LaunchedEffect(loginUiState.isSignedIn) {
                if (loginUiState.isSignedIn) {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
                    loginViewModel.onNavigationHandled()
                }
            }

            LoginScreen(
                uiState = loginUiState,
                onContinueAsGuest = loginViewModel::continueAsGuest,
                onEmailLoginClick = {
                    navController.navigate(Screen.EmailLogin.route)
                },
                onCreateAccountClick = {
                    navController.navigate(Screen.Register.route)
                }
            )
        }
        composable(Screen.EmailLogin.route) {
            val emailLoginViewModel: EmailLoginViewModel = viewModel()
            val emailLoginUiState by emailLoginViewModel.uiState.collectAsStateWithLifecycle()

            LaunchedEffect(emailLoginUiState.isSignedIn) {
                if (emailLoginUiState.isSignedIn) {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
                    emailLoginViewModel.onNavigationHandled()
                }
            }

            EmailLoginScreen(
                uiState = emailLoginUiState,
                onEmailChange = emailLoginViewModel::onEmailChange,
                onPasswordChange = emailLoginViewModel::onPasswordChange,
                onLoginClick = emailLoginViewModel::signIn,
                onBackToWelcomeClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.Register.route) {
            val registerViewModel: RegisterViewModel = viewModel()
            val registerUiState by registerViewModel.uiState.collectAsStateWithLifecycle()

            LaunchedEffect(registerUiState.isSignedIn) {
                if (registerUiState.isSignedIn) {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
                    registerViewModel.onNavigationHandled()
                }
            }

            RegisterScreen(
                uiState = registerUiState,
                onEmailChange = registerViewModel::onEmailChange,
                onPasswordChange = registerViewModel::onPasswordChange,
                onRegisterClick = registerViewModel::register,
                onBackToLoginClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen()
        }
    }
}
