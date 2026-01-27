package com.example.test_navegacion.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeScreen(onNavigateHome : () -> Unit, onNavigateDenied : () -> Unit) {

    //variable para guardar el input (edad) y operar con él
    var edad by remember { mutableStateOf("") }

    //CENTRADO DE ELEMENTOS
    Column (modifier = Modifier.padding(50.dp)){

        //LABEL
        Text("Welcome to you game shop")
            Text("Insert your age:")

        //CAJA RELLENO
        TextField(
            value = edad,
            onValueChange = { newText -> edad = newText } ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) //teclado numérico

        )
        //CUANDO HAGAMOS CLICK EN EL BOTÓN
        Button(onClick = {
            //SI LA EDAD ES TRUE (>18) -> función navegateHome
                        if (validateAge(edad.toInt())) {
                            onNavigateHome()
                        } else { //Si no, página con la ley
                            onNavigateDenied()
                        } })
            { Text("Submit") }
    }
}

fun validateAge(edad : Int) : Boolean{
    return edad >= 18;
}
