package com.example.test_navegacion.screens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_navegacion.data.Videogame
import com.example.test_navegacion.ui.theme.PurpleGrey40
import java.math.BigDecimal
import java.math.RoundingMode

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

            Text(
                text = "${game.nombre}", modifier = Modifier.weight(2f),
                fontSize = 18.sp, color = Color.White
            )

            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Favorite",
                modifier = Modifier
                    .weight(1f)
                    .size(30.dp)
                    .clickable { onNavigationBuy() },
                tint = Color.White
            )
        }

        //BODY
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray.copy(alpha = 0.3f)),
            horizontalArrangement = Arrangement.SpaceBetween, // Empuja elementos a los extremos
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .width(200.dp)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                Alignment.CenterVertically
            ) {
                Text("Units: ", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.White)
                //Restar
                IconButton({ if (quantity > 0) quantity-- }) {
                    Text("-", fontSize = 20.sp, color = Color.White)
                }
                //Valor que cambia
                Text(
                    quantity.toString(),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(16.dp),
                    color = Color.White
                )
                //Sumar
                IconButton(
                    { quantity++ }
                ) {
                    Text("+", fontSize = 20.sp, color = Color.White)
                }
            }
            Button({ addToBuy(quantity) },
                colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6CC4B1), // Color de fondo
                contentColor = Color.White // Color del texto
            ),modifier = Modifier.padding(5.dp)) {
                Text("Add", fontSize = 16.sp, color = Color.White)
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
                    .weight(0.5f)
                    .fillMaxHeight(),
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
                    .fillMaxHeight()
                    .weight(0.5f)
            ) {
                //text1
                showInfo(game, quantity)
            }
        }
    }
}

//Hardcodeado a muerte -> TODO: Buscar una forma más eficiente
@Composable
fun showInfo(game: Videogame, quantity: Int) {

    //FECHA SALIDA
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)) // Borde redondeado general
            .background(PurpleGrey40) // Color de fondo
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp)) // Borde redondeado
            .padding(4.dp) // Padding INTERNO para que el texto no toque el borde
            .background(PurpleGrey40)
    ) {
        Text(
            text = "Release date: ",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(text = "${game.fechaSalida}", fontSize = 15.sp, color = Color.White)
    }
    Spacer(modifier = Modifier.height(20.dp))

    //PLATAFORMAS
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)) // Borde redondeado general
            .background(PurpleGrey40) // Color de fondo
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp)) // Borde redondeado
            .padding(4.dp) // Padding INTERNO para que el texto no toque el borde
            .background(PurpleGrey40)
        ) {
        //text2
        Text(
            text = "Platforms: ",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(text = "${game.plataforma}", fontSize = 15.sp, color = Color.White)
    }
    Spacer(modifier = Modifier.height(20.dp))

    //PRECIO
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)) // Borde redondeado general
            .background(PurpleGrey40) // Color de fondo
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp)) // Borde redondeado
            .padding(4.dp) // Padding INTERNO para que el texto no toque el borde
            .background(PurpleGrey40)
    ) {
        //text3
        Text(text = "Price: ", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Text(text = "${game.precio} €", fontSize = 15.sp, color = Color.White)
    }
    Spacer(modifier = Modifier.height(20.dp))

    //TOTAL UNIDADES
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)) // Borde redondeado general
            .background(PurpleGrey40) // Color de fondo
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp)) // Borde redondeado
            .padding(4.dp) // Padding INTERNO para que el texto no toque el borde
            .background(PurpleGrey40)
    ) {
        Text(
            "Total units: $quantity",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.White
        )
    }
    Spacer(modifier = Modifier.height(30.dp))

    //TOTAL PRECIO
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)) // Borde redondeado general
            .background(PurpleGrey40) // Color de fondo
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp)) // Borde redondeado (solo el borde)
            .padding(4.dp) // Padding INTERNO para que el texto no toque el borde
    ) {
        Text( //BigDecimal se le pasa un double, y se utiliza el metodo setScale,
              // mediante un numero (decimales a redondear) y una funcion, redondea a la cantidad seleccionada y lo pasa a double
            "Total to pay: ${BigDecimal(game.precio * quantity).setScale(2, RoundingMode.HALF_UP).toDouble()}€",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.White
        )
    }
}


//
//
//        Spacer(modifier = Modifier.padding(20.dp))



