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
        startDestination = "welcome"
    ) {

        composable ("home") {

            HomeScreen(onClick = { navCont.navigate("welcome") })



        }

        composable("welcome") {

            WelcomeScreen(onNavigationHome = { navCont.navigate("home")}, onNavigationDenied = { navCont.navigate("denied")})

        }

        composable("denied") {

            DeniedScreen()

        }

    }

}