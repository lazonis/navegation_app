package com.example.test_navegacion.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.serialization.json.Json
import androidx.compose.foundation.lazy.items
import com.example.test_navegacion.data.Videogame
import androidx.compose.ui.platform.LocalResources

//popBackStack() en ruta a WELCOME

@Composable
fun HomeScreen(
    onNavigationWelcome: () -> Unit,
    onNavigationDetail: (String) -> Unit,
    onNavigationBuy: () -> Unit,
    lgames: List<Videogame>,
) {
    //Guardamos el context que nos permite acceder a los recursos de dentro de /res/raw
    Column(modifier = Modifier.padding(50.dp)) {
        Text("INICIO / HOME")
        Button(onClick = { onNavigationWelcome() }) {
            Text("Go Welcome")
        }
        LazyColumn {
            items(lgames) { game ->
                Text(game.nombre)
                //Al hacer click en el botón, elevamos el id hacia arriba
                Button(onClick = { onNavigationDetail(game.id.toString()) }) {

                    Text("Ir a Detail")
                }
            }
        }
    }
}