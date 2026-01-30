package com.example.test_navegacion.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.test_navegacion.data.getV

@Composable

fun Navegation(){

    val navCont = rememberNavController()

    val context = LocalContext.current
    val gameList = getV(context)

    var id by remember { mutableStateOf(0) }

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
                        onNavigationDetail = { idClick -> navCont.navigate("detail/$idClick")},
                        gameList = gameList)

        }

        composable ("detail/{idGame}",
                    listOf(navArgument("idGame"){ type = NavType.IntType})) {

            backStackEntry ->

            val gameId = backStackEntry.arguments?.getInt("idGame") ?: 0

            val gameFound = gameList.find { it.id == gameId }


            if(gameFound != null){
                DetailScreen(onNavigationHome = {navCont.navigate("home"){

                    popUpTo("home"){
                        inclusive = false
                    }
                } },

                    onNavigationBuy = {navCont.navigate("buy")},
                    game = gameFound)

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
                              inclusive = false
                          }
                      }},

                      onNavigationDetail = {navCont.navigate("Detail")})

        }

    }

}