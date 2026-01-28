package com.example.test_navegacion.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable

fun HomeScreen(onNavigationWelcome: () -> Unit, onNavigationDetail: () -> Unit, onNavigationBuy: () -> Unit){


    Column(modifier = Modifier.padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

    Text( text = "(Pantalla Home)")

        Spacer(modifier = Modifier.padding(20.dp))


    Button(onClick = {onNavigationWelcome()}) {

        Text("Ir a Welcome")
    }

        Spacer(modifier = Modifier.padding(20.dp))

    Button(onClick = {onNavigationDetail()}){

        Text("Ir a Detail")
    }
        Spacer(modifier = Modifier.padding(20.dp))


    Button(onClick = {onNavigationBuy()}){

            Text("Ir a Buy")
    }


    }
}
