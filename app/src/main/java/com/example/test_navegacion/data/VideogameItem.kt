package com.example.test_navegacion.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class VideogameItem(
    val fechaSalida: String,
    val id: String,
    val imgNombre: String,
    val nombre: String,
    val plataforma: List<String>,
    val precio: String
)
