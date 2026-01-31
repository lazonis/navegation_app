package com.example.test_navegacion.data

import android.content.Context
import com.example.test_navegacion.R
import kotlinx.serialization.Serializable
import java.io.InputStreamReader

@Serializable
data class Videogame(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val plataforma : List<String>,
    val fechaSalida : String,
    val imgNombre : String
)

