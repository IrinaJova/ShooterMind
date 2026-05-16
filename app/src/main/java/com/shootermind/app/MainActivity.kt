package com.shootermind.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.shootermind.app.ui.ShooterMindApp
import com.shootermind.app.ui.theme.ShooterMindTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShooterMindTheme {
                ShooterMindApp()
            }
        }
    }
}
