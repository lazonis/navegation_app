package com.example.test_navegacion.data

import android.content.Context
import com.example.test_navegacion.R
import com.google.gson.Gson
import java.io.InputStreamReader

data class Videogame(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val plataforma : List<String>,
    val fechaSalida : String,
    val imgNombre : String
)


fun getVideogameList(context : Context) : List<Videogame>{

    val inputStream = context.resources.openRawResource(R.raw.data)

    val reader = InputStreamReader(inputStream)

    val listaJuegos = Gson().fromJson(reader, Array<Videogame>::class.java)

    return listaJuegos.toList()

}