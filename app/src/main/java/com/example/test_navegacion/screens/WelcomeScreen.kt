package com.example.test_navegacion.screens

import ads_mobile_sdk.h4
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WelcomeScreen(onNavigationHome: () -> Unit, onNavigationDenied: () -> Unit) {

    var text by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(
            modifier = Modifier.padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "~WELCOME~", color = Color.White, fontSize = 30.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "to the big boys game shop", color = Color.White, fontSize = 18.sp, textAlign = TextAlign.Center)


            Spacer(modifier = Modifier.padding(20.dp))

            TextField(
                value = text,
                onValueChange = { nuevoTexto ->
                    //Si está vacío nuevoTexto/texto = 0 -> pag denied
                    //Si tod el texto son dígitos -> esos digitos = nuevoTexto
                    if (nuevoTexto.isEmpty() || nuevoTexto.all { it.isDigit() }) {
                    text = nuevoTexto
                        //esta condición evita que podamos escribir cualquier cosa que
                } },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.padding(20.dp))

            Button(onClick = {

                if (validateAge(text)) {
                    onNavigationHome()
                } else {
                    onNavigationDenied()
                }
            }
            ) {

                Text(text = "ENTER", color = Color.White)

            }

        }
    }

}


fun validateAge(text: String): Boolean {
    //Si el valor es null -> asocia 0 de base
    val edad = text.toIntOrNull() ?: 0

    return edad >= 18 && edad < 100

}