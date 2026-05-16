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
import com.shootermind.app.ui.auth.LoginScreen
import com.shootermind.app.ui.auth.LoginViewModel
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
                onCreateAccountClick = {
                    navController.navigate(Screen.Register.route)
                }
            )
        }
        composable(Screen.Register.route) {
            RegisterScreen(
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
