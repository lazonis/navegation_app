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
import com.example.test_navegacion.data.VideogameItem
import kotlinx.serialization.json.Json
import androidx.compose.foundation.lazy.items

//popBackStack() en ruta a WELCOME

@Composable
fun HomeScreen(
    onNavigateWelc: () -> Unit,
    onNavigateDetail: () -> Unit,
    onNavigateBuy: () -> Unit,
) {
    //Guardamos el context que nos permite acceder a los recursos de dentro de /res/raw
    val context = LocalContext.current
    //Variable que guarda una función anónima
    // -> generar lista de Objetos Videogame
    val lJuegos = remember {
        try {
            val input = context.resources.openRawResource(com.example.test_navegacion.R.raw.data)

            val jsonString = input.bufferedReader().use { it.readText() }

            val jsonTools = Json { ignoreUnknownKeys = true }

            // D. Convertir a Lista (La magia de Kotlinx)
            jsonTools.decodeFromString<List<VideogameItem>>(jsonString)

        } catch (e: Exception) {
            e.printStackTrace()
            emptyList<VideogameItem>()
        }
    }

    Column(modifier = Modifier.padding(50.dp)) {

        Text("INICIO / HOME")
        Button(onClick = { onNavigateWelc() }) {
            Text("Go Welcome")
        }
        LazyColumn{
            items(lJuegos) { juego ->
                Text(juego.nombre)
                println(juego.nombre)
            }
        }
    }
}