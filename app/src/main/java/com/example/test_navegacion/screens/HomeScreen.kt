package com.example.test_navegacion.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.unit.dp
import com.example.test_navegacion.data.Videogame
import kotlinx.serialization.json.Json


@Composable

fun HomeScreen(lgames : List<Videogame>,onNavigationWelcome: () -> Unit, onNavigationDetail: (String) -> Unit){


    Column(modifier = Modifier.padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

    Text( text = "(Pantalla Home)")

        Spacer(modifier = Modifier.padding(20.dp))


    Button(onClick = {onNavigationWelcome()}) {

        Text("Ir a Welcome")
    }
        Spacer(modifier = Modifier.padding(20.dp))


        LazyColumn( content= {

            items(lgames) { game ->

                Row(){
                    Text(game.nombre)

                    Button(onClick = {onNavigationDetail(game.id.toString())}){

                        Text("Ir a Detail")
                    }
                }
            }
        })



    }
}
