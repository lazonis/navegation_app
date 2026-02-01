package com.example.test_navegacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
                .fillMaxWidth()
                .height(70.dp)
                .padding(15.dp),
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

            Spacer(modifier = Modifier.padding(5.dp))

            Text(
                text = "ORDER DETAILS",
                color = Color.White,
                fontSize = 22.sp
            )

        }
        //BODY
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row {
                Column {
                    Text(
                        "Total to pay: ${selectedItems.entries.sumOf { it.key.precio * it.value }}€",
                        color = Color.White
                    )
                    Text(
                        "Total items: ${selectedItems.values.size}",
                        color = Color.White
                    )
                    Button(onClick = onNavigationHome, modifier = Modifier.fillMaxWidth()) {
                        Text("Keep looking", color = Color.White)
                    }
                }

            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(5.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(selectedItems.toList()) { (game, quantity) ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, Color.White, RoundedCornerShape(8.dp))
                            .background(Color.Blue)
                            .padding(20.dp, 10.dp, 0.dp, 5.dp)
                    ) {
                        Text(text = game.nombre, color = Color.White)
                        Text(text = "Quantity : $quantity", color = Color.White)
                        Text(text = "Subtotal: ${game.precio * quantity} €", color = Color.White)
                        IconButton({ onRemoveGame(game) },
                            modifier = Modifier.padding(0.dp,0.dp,20.dp,0.dp)
                                .background(Color.White, RoundedCornerShape(70.dp))) {
                            Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                        }
                    }
                }

            }

        }


    }
}