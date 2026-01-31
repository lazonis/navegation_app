package com.example.test_navegacion.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_navegacion.data.Videogame
import kotlin.times

@Composable
fun DetailScreen(
    game: Videogame,
    onNavigationHome: () -> Unit,
    onNavigationBuy: () -> Unit,
    addToBuy: (Int) -> Unit,
) {

    //Solo es recordado en las pantallas detalles (mientras estamos en cada una)
    //Establecemos 0 como número base
    var quantity by remember { mutableIntStateOf(0) }

    //TOPBAR
    Column(
        modifier = Modifier

            .padding(18.dp)
            .fillMaxSize()
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .background(Color.Blue)
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
                    .size(40.dp)
            )

            Spacer(modifier = Modifier.padding(15.dp))

            Text(
                text = "${game.nombre}", modifier = Modifier.weight(2f),
                fontSize = 18.sp
            )

            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Favorite",
                modifier = Modifier
                    .weight(1f)
                    .size(30.dp)
                    .clickable { onNavigationBuy() }
            )
        }

        //BODY
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween, // Empuja elementos a los extremos
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.width(200.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                Alignment.CenterVertically
            ) {
                Text("Uds: ", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                //Restar
                IconButton({ if (quantity > 0) quantity-- }) {
                    Text("-", fontSize = 20.sp)
                }
                //Valor que cambia
                Text(quantity.toString(), fontSize = 18.sp, modifier = Modifier.padding(16.dp))
                //Sumar
                IconButton(
                    { quantity++ },
                    modifier = Modifier.border(BorderStroke(1.dp, Color.Black))
                ) {
                    Text("+", fontSize = 20.sp)
                }
            }
            Button({ addToBuy(quantity) }, border = BorderStroke(2.dp, Color.Black)) {
                Text("Add", fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(), // Que ocupe todo el ancho
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically// Espacio entre foto y texto
        ) {
            // 1. IZQUIERDA: La Foto (Tamaño Fijo)
            Box(
                modifier = Modifier
                    .weight(0.5f).fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(
                        id = LocalContext.current.resources.getIdentifier(
                            game.imgNombre,
                            "drawable",
                            LocalContext.current.packageName
                        )
                    ),
                    contentDescription = "Imagen",
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight().weight(0.5f)
            ) {
                //text1
                showInfo(game,quantity)
            }
        }
    }
}

//Hardcodeado a muerte -> TODO: Buscar una forma más eficiente
@Composable
fun showInfo(game : Videogame, quantity : Int){
    Spacer(modifier = Modifier.height(20.dp))
    Text(text = "Fecha salida: ", fontSize = 15.sp, fontWeight = FontWeight.Bold)
    Text(text = "${game.fechaSalida}", fontSize = 15.sp)
    //text2
    Spacer(modifier = Modifier.height(40.dp))
    Text(text = "Plataformas: ", fontSize = 15.sp, fontWeight = FontWeight.Bold)
    Text(text = "${game.plataforma}", fontSize = 15.sp)
    //text3
    Spacer(modifier = Modifier.height(40.dp))
    Text(text = "Precio: ", fontSize = 15.sp, fontWeight = FontWeight.Bold)
    Text(text = "${game.precio} €", fontSize = 15.sp)

    Spacer(modifier = Modifier.height(40.dp))
    Text("Total uds: $quantity", fontWeight = FontWeight.Bold,  fontSize = 15.sp)
    Spacer(modifier = Modifier.height(20.dp))
    Text("Total a pagar: ${game.precio * quantity}", fontWeight = FontWeight.Bold,  fontSize = 15.sp)
}


//
//
//        Spacer(modifier = Modifier.padding(20.dp))



