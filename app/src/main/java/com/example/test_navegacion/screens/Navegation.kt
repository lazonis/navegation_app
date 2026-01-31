package com.example.test_navegacion.screens

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.test_navegacion.data.Videogame

@Composable

fun Navegation(gameList : List<Videogame>, context : Context){

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
                        onNavigationDetail = { idClick -> navCont.navigate("detail/$idClick") },
                        lgames = gameList)

        }

        composable ("detail/{idGame}",
                    listOf(navArgument("idGame"){ type = NavType.IntType})) {

            backStackEntry ->

            val gameId = backStackEntry.arguments?.getInt("idGame") ?: 0

            val gameFound = gameList.find { it.id == gameId }


            if(gameFound != null){
                DetailScreen(onNavigationHome = {navCont.navigate("home"){

                    popUpTo("home"){
                        inclusive = true
                    }
                } },

                    onNavigationBuy = {navCont.navigate("buy")},
                    game = gameFound, context = context)

            }


        }

        composable("buy"){

            BuyScreen(onNavigationWelcome = {navCont.navigate("welcome"){
                        popUpTo("welcome"){
                            inclusive = true
                        }
            } },

                      onNavigationHome = {navCont.navigate("home"){
                          popUpTo("home"){
                              inclusive = true
                          }
                      }},

                      onNavigationDetail = {navCont.navigate("Detail")})

        }

    }

}