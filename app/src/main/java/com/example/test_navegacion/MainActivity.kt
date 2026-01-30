package com.example.test_navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.test_navegacion.screens.Navigation
import com.example.test_navegacion.ui.theme.Test_navegacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test_navegacionTheme {
                Navigation()
            }
        }
    }
}

