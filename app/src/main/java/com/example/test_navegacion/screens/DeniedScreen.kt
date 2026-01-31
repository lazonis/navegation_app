package com.example.test_navegacion.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable

fun DeniedScreen() {

    Column(
        modifier = Modifier.padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "(Pantalla Denied)")


        Spacer(modifier = Modifier.padding(20.dp))


        Text(text = "(La ley dise que no puedes estar aca manito)")

    }
}