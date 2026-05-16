package com.shootermind.app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.shootermind.app.ui.ShooterMindApp
import com.shootermind.app.ui.theme.ShooterMindTheme

class MainActivity : AppCompatActivity() {
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
