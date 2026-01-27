package com.example.test_navegacion.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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

//popBackStack() en ruta a WELCOME
@Composable
fun HomeScreen(onNavigate : () -> Unit) {

    Column (modifier = Modifier.padding(50.dp)) {

        Text("INICIO / HOME")
        Button(onClick = { onNavigate() }) {
            Text("Go Welcome")
        }
    }
}