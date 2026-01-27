package com.example.test_navegacion.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
fun WelcomeScreen(onNavigateHome: () -> Unit, onNavigateDenied: () -> Unit) {

    //variable para guardar el input (edad) y operar con él
    var edad by remember { mutableStateOf("") }

    //variable para controlar si mostramos error
    var hasError by remember { mutableStateOf(false) }

    //CENTRADO DE ELEMENTOS
    Column(modifier = Modifier.padding(50.dp)) {

        //LABEL
        Text("Welcome to you game shop")
        Text("Insert your age:")

        //CAJA RELLENO
        TextField(
            value = edad,
            onValueChange = { newText -> edad = newText },

            isError = hasError,
            supportingText = {
                if (hasError) {
                    Text("Este campo es obligatorio", color = MaterialTheme.colorScheme.error)
                }
            }
        )
        //CUANDO HAGAMOS CLICK EN EL BOTÓN
        Button(onClick = {
            //Hay que arreglar el input de Strings para que solo acepte enteros
            //Si está vacío el text field -> error, sino
            if (edad.isBlank()) {
                hasError = true
            } else {
                hasError = false
            }
            //Compruebo edad
            if (validateAge(edad.toIntOrNull())) {
                onNavigateHome()
            } else { //Si no, página con la ley
                onNavigateDenied()
            }
        })
        { Text("Submit") }

    }
}

fun validateAge(edad: Int?): Boolean {
    if (edad != null) {
        return edad >= 18
    };
    return false;
}
