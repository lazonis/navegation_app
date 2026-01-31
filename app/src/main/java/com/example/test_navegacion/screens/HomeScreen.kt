package com.example.test_navegacion.screens

import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import com.example.test_navegacion.data.Videogame
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.test_navegacion.R


//popBackStack() en ruta a WELCOME

@Composable
fun HomeScreen(
    onNavigationWelcome: () -> Unit,
    onNavigationDetail: (Int?) -> Unit,
    onNavigationBuy: () -> Unit,
    lgames: List<Videogame>,
) {

    var juego by remember { mutableStateOf<Videogame?>(Videogame(
        0, "Not selected",
        precio = 0.0,
        plataforma = listOf(),
        fechaSalida = "0",
        imgNombre = "Ninguno")) }

    //Guardamos el context que nos permite acceder a los recursos de dentro de /res/raw

    Column(modifier = Modifier.padding(15.dp).fillMaxSize()) {

        Row(modifier = Modifier.fillMaxWidth().height(70.dp).padding(10.dp),
            verticalAlignment = Alignment.CenterVertically){

            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "Favorite",
                modifier = Modifier.clickable{ onNavigationWelcome() }.size(40.dp),
                tint = Color.White
            )

            Spacer(modifier = Modifier.padding(15.dp))

            Text(text = "HOME", modifier = Modifier.weight(2f),
                fontSize = 22.sp,
                color = Color.White)

            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Favorite",
                modifier = Modifier.weight(1f).size(30.dp).clickable{onNavigationBuy()},
                tint = Color.White
            )

            Button(onClick = { onNavigationDetail(juego?.id)},
                    modifier = Modifier.width(110.dp).height(40.dp).weight(2f)) {
                Text("Details",color = Color.White)
            }

        }

        Spacer(modifier = Modifier.padding(20.dp))

        Row(modifier = Modifier.fillMaxWidth().height(50.dp).background(Color.Gray.copy(alpha = 0.3f),RoundedCornerShape(16.dp)).padding(10.dp),
            verticalAlignment = Alignment.CenterVertically){
        Text(text = "Game Selected: ${juego?.nombre}",color = Color.White)
        }
        Spacer(modifier = Modifier.padding(20.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(lgames) { game ->

                Row(modifier = Modifier.background(Color.Blue, RoundedCornerShape(16.dp))
                                        .fillMaxSize()
                                        .height(80.dp)
                                        .clickable{ juego = game }
                                        .padding(10.dp)
                                        ,
                    verticalAlignment = Alignment.CenterVertically){

                    Text(game.nombre, modifier = Modifier.weight(1f),color = Color.White)
                    Text(game.precio.toString() + " €",color = Color.White)
                    //Al hacer click en el botón, elevamos el id hacia arriba

                }
            }
        }
    }
}