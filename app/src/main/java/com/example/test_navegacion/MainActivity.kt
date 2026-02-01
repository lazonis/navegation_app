package com.example.test_navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.res.painterResource
import com.example.test_navegacion.data.Videogame
import com.example.test_navegacion.screens.Navegation
import com.example.test_navegacion.ui.theme.Test_navegacionTheme
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test_navegacionTheme {
                //FONDO DE LA APLICACIÓN
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.colorback),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Scaffold(
                    containerColor = Color.Transparent,
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    Column(modifier = Modifier.padding(innerPadding)) {
                        Navegation(getGameList())

                    }
                }
            }
        }
    }
}

//Como el método remember (lambda) necesita una función @composable
//La declarmos aquí y se lo pasamos al Navegation
@Composable
fun getGameList(): List<Videogame> {
    val resources = LocalResources.current
    //Variable que guarda una función anónima
    // -> generar lista de Objetos Videogame
    val lgames = remember {
        try {
            val input = resources.openRawResource(R.raw.data)

            val jsonString = input.bufferedReader().use { it.readText() }

            val jsonTools = Json { ignoreUnknownKeys = true }

            // D. Convertir a Lista
            jsonTools.decodeFromString<List<Videogame>>(jsonString)

        } catch (e: Exception) {
            e.printStackTrace()
            emptyList<Videogame>()
        }
    }

    return lgames
}

