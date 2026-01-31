package com.example.test_navegacion.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.test_navegacion.data.Videogame

@Composable
fun DetailScreen(
    game: Videogame,
    onNavigationHome: () -> Unit,
    onNavigationBuy: () -> Unit,
    addToBuy : (Int) -> Unit) {

    //Solo es recordado en las pantallas detalles (mientras estamos en cada una)
    //Establecemos 0 como número base
    var quantity by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.padding(50.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { onNavigationHome() }) {
            Text("←")
        }
        Button(onNavigationBuy) {Text("GO TO CHART") }
        Text(text = "Details ${game.nombre}")
        Text(text = "${game.fechaSalida}")
        Text(text = "${game.precio} €")
        Text(text = " ${game.plataforma}")
        Row(
            verticalAlignment = Alignment.CenterVertically)
        {
            Button({
                if (quantity >0) quantity--
            }) { Text("-") }
            Text(
                text = quantity.toString(),
            )
            Button({quantity++}) { Text("+")}
        }

        //BOTON DE COMPRA - AÑADIMOS TOTAL ELEGIDO AL VAL itemsSeleccionados
        //del navegation a través de los parámetros
        Button(
            {addToBuy(quantity)},
            modifier = Modifier.padding(horizontal = 32.dp)
        ) { Text("Buy")}

        Image(
            painter = painterResource(
                id = LocalContext.current.resources.getIdentifier(
                    game.imgNombre,
                    "drawable",
                    LocalContext.current.packageName
                )
            ),
            contentDescription = "Imagen"
        )



        Spacer(modifier = Modifier.padding(20.dp))

    }
}
