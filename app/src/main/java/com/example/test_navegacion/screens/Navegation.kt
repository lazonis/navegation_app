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


        composable("welcome") {

            WelcomeScreen(onNavigationHome = { navCont.navigate("home")},
                          onNavigationDenied = { navCont.navigate("denied")})

        }

        composable("denied") {

            DeniedScreen()

        }


        composable ("home") {

            HomeScreen(onNavigationWelcome = { navCont.popBackStack() },
                        onNavigationDetail = { navCont.navigate("detail")})

        }

        composable ("detail") {

            DetailScreen(onNavigationHome = {navCont.navigate("home"){

                            popUpTo("home"){
                                inclusive = false
                            }
                        } },

                         onNavigationBuy = {navCont.navigate("buy")} )

        }

        composable("buy"){

            BuyScreen(onNavigationWelcome = {navCont.navigate("welcome"){
                        popUpTo("welcome"){
                            inclusive = true
                        }
            } },

                      onNavigationHome = {navCont.navigate("home"){
                          popUpTo("home"){
                              inclusive = false
                          }
                      }},

                      onNavigationDetail = {navCont.navigate("Detail")})

        }

    }

}