package com.example.test_navegacion.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun WelcomeScreen(onNavigationHome : () -> Unit, onNavigationDenied : () -> Unit){

    var text by remember {mutableStateOf("")}

    Column(modifier = Modifier.padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "(Pantalla Welcome)")


        Spacer(modifier = Modifier.padding(20.dp))

        TextField(
            value = text,
            onValueChange = { nuevoTexto -> text = nuevoTexto },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.padding(20.dp))

        Button(onClick = {

            if(validateAge(text)) {
                onNavigationHome()
            }
            else {
                onNavigationDenied()
            }
        }
        )  {

            Text( text = "Acceder")

        }

    }

}


fun validateAge( text : String ) : Boolean {

    if(text.isEmpty()){
        return false
    }

    else {

        if (text.toInt() >= 18) {
            return true
        } else {
            return false
        }
    }

}