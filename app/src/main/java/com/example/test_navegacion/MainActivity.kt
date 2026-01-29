package com.example.test_navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.test_navegacion.data.getV
import com.example.test_navegacion.screens.Navegation
import com.example.test_navegacion.ui.theme.Test_navegacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test_navegacionTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->

                    Column(modifier = Modifier.padding(innerPadding)) {
                        Navegation()
                        val context = LocalContext.current
                        getV(context)
                    }
                }
            }
        }
    }
}
