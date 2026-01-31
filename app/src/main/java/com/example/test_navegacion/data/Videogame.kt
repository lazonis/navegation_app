package com.example.test_navegacion.data

import android.content.Context
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Videogame(
    val fechaSalida: String,
    val id: String,
    val imgNombre: String,
    val nombre: String,
    val plataforma: List<String>,
    val precio: String
)



