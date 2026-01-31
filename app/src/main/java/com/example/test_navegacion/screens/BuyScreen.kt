package com.example.test_navegacion.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.test_navegacion.data.Videogame


@Composable
fun BuyScreen(
    onNavigationWelcome: () -> Unit,
    onNavigationHome: () -> Unit,
    selectedItems: Map<Videogame, Int>,
    onRemoveGame: (Videogame) -> Unit,
) {

    Column(
        modifier = Modifier.padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { onNavigationWelcome() }) {
            Text("RESET")
        }

        Text(text = "Order details")


        LazyColumn {
            items(selectedItems.toList()) { (game, quantity) ->
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(game.nombre)
                        Text("Cantidad: ${quantity}")
                    }
                    Text("Subtotal: ${game.precio * quantity}€")
                }
                IconButton({ onRemoveGame(game) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                }
            }
        }
    }

    Row {
        Column {
            Text("Total a pagar: ${selectedItems.entries.sumOf { it.key.precio * it.value }}€")
            Button(onClick = onNavigationHome, modifier = Modifier.fillMaxWidth()) {
                Text("Seguir Comprando")
            }
        }

    }
}