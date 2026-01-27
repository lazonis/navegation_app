package com.example.test_navegacion.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DeniedScreen(onNavigateWelc : () -> Unit){

    Column(modifier = Modifier.padding(50.dp)) {
        Text("ERES MENOR, DENIED")

        Button(onClick = onNavigateWelc) {
            Text("BACK TO WELCOME")
        }
    }
}