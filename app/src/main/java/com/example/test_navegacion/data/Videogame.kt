package com.example.test_navegacion.data

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.test_navegacion.R
import com.google.gson.Gson
import java.io.InputStreamReader
import java.util.Objects

data class Videogame(
    val id: Int,
    val nombre: String,
    val launchYear: Int,
    val image: Int,
    val company: String,
    val precio: Double,
)


fun getV(context : Context){

    val inputStream = context.resources.openRawResource(R.raw.data)

    val reader = InputStreamReader(inputStream)

    val listaJuegos = Gson().fromJson(reader, Array<Videogame>::class.java)

    listaJuegos.forEach { println(it.nombre) }

}