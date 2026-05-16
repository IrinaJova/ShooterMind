package com.shootermind.app.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shootermind.app.ui.navigation.ShooterMindNavHost

@Composable
fun ShooterMindApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        ShooterMindNavHost(
            modifier = Modifier.padding(innerPadding)
        )
    }
}
