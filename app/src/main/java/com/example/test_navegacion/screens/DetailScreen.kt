package com.example.test_navegacion.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.test_navegacion.R
import com.example.test_navegacion.data.Videogame

@Composable
fun DetailScreen(onNavigationHome: () -> Unit, onNavigationBuy: () -> Unit, game : Videogame, context : Context){

    Column(modifier = Modifier.padding(50.dp),

        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "(Pantalla Detail)")


        Spacer(modifier = Modifier.padding(20.dp))

        Button(onClick = {onNavigationHome()}) {
            Text("Ir a Home")
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Button(onClick = {onNavigationBuy()}) {
            Text("Ir a Buy")
        }

        Text(text = game.nombre)
        Text(text = game.fechaSalida)

        Image(
            painter = painterResource(id = context.resources.getIdentifier( game.imgNombre,"drawable", context.packageName)),
            contentDescription = "Imagen Jueguito"
        )

    }


}