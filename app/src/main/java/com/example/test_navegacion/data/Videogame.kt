package com.example.test_navegacion.data

import kotlinx.serialization.Serializable

@Serializable
data class VideogameItem(
    val fechaSalida: String,
    val id: String,
    val imgNombre: String,
    val nombre: String,
    val plataforma: List<String>,
    val precio: String
)


