package com.example.test_navegacion.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeScreen(onNavigate : () -> Unit) {

    //variable de texto que representará
    var text by remember { mutableStateOf("") }

    Column (modifier = Modifier.padding(50.dp)){
        Text("Welcome to you game shop")
            Text("Insert your age:")
        TextField(
            value = text,
            onValueChange = { newText -> text = newText }
        )
        Button(onClick = {onNavigate()}) {
            Text("Go Home")
        }
    }

}
