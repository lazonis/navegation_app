package com.example.test_navegacion.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable

fun Navegation(){

    val navCont = rememberNavController()

    NavHost(
        navController = navCont,
        startDestination = "home"
    ) {

        composable ("home") {

            HomeScreen(onClick = { navCont.navigate("welcome")})


        }

        composable("welcome") {

            WelcomeScreen(onClick = { navCont.navigate("home")} )

        }

    }

}