package com.example.test_navegacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_navegacion.data.Videogame


@Composable
fun BuyScreen(
    onNavigationWelcome: () -> Unit,
    onNavigationHome: () -> Unit,
    selectedItems: Map<Videogame, Int>,
    onRemoveGame: (Videogame) -> Unit,
) {
    //TOPBAR
    Column(
        modifier = Modifier

            .padding(18.dp)
            .fillMaxSize()
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .background(Color.Transparent)
                .fillMaxWidth()
                .height(70.dp)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "Favorite",
                modifier = Modifier
                    .clickable { onNavigationHome() }
                    .size(40.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.padding(15.dp))

            Text(text = "Order Details", color = Color.White, fontSize = 18.sp)

            Button(onClick = { onNavigationWelcome() }) {
                //TODO: FIX BUTTON SIZE
                Text("RESET", color = Color.White)
            }

        }
        //BODY
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row {
                Column {
                    Text(
                        "Total a pagar: ${selectedItems.entries.sumOf { it.key.precio * it.value }}€",
                        color = Color.White
                    )
                    Button(onClick = onNavigationHome, modifier = Modifier.fillMaxWidth()) {
                        Text("Seguir Comprando", color = Color.White)
                    }
                }

            }

            LazyColumn() {
                items(selectedItems.toList()) { (game, quantity) ->

                    Row(
                        modifier = Modifier
                            .background(Color.Blue, RoundedCornerShape(16.dp))

                    ) {

                        Text(text = game.nombre, color = Color.White)
                        Text(text = "Cantidad : ${quantity.toString()} €", color = Color.White)
                        Text(text = "Subtotal: ${game.precio * quantity}")

                    }
                }

            }

        }


    }
}