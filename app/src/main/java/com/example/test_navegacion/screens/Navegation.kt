package com.example.test_navegacion.screens

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.test_navegacion.data.Videogame

@Composable

fun Navegation(gameList: List<Videogame>) {

    val navCont = rememberNavController()

    //Carrito -> estado global para guardar las cantidades elegidas de cada jueguito
    var selectedItems = remember { mutableStateMapOf<Videogame, Int>() }


    NavHost(
        navController = navCont,
        startDestination = "welcome"
    ) {

        composable("welcome") {
            WelcomeScreen(
                onNavigationHome = { navCont.navigate("home") },
                onNavigationDenied = { navCont.navigate("denied") })
        }

        composable("denied") {

            DeniedScreen({navCont.navigate("welcome")})

        }

        composable("home") {

            HomeScreen(
                onNavigationWelcome = { navCont.popBackStack() },
                onNavigationDetail = { idClick -> navCont.navigate("detail/$idClick") },
                onNavigationBuy = { navCont.navigate("buy") },
                lgames = gameList
            )

        }

        composable(
            "detail/{idGame}",
            listOf(navArgument("idGame") { type = NavType.IntType })
        ) {

                backStackEntry ->

            val gameId = backStackEntry.arguments?.getInt("idGame") ?: 0

            val gameFound = gameList.find { it.id == gameId }


            if (gameFound != null) {
                DetailScreen(
                    onNavigationHome = {
                        navCont.navigate("home") {

                            popUpTo("home") {
                                inclusive = true
                            }
                        }
                    },
                    addToBuy = { addQuantity ->
                        val actualQuantity = selectedItems[gameFound] ?: 0
                        selectedItems[gameFound] = actualQuantity + addQuantity
                    },
                    onNavigationBuy = { navCont.navigate("buy") },
                    game = gameFound
                )

            }


        }

        composable("buy") {

            BuyScreen(
                onNavigationWelcome = {
                    navCont.navigate("welcome") {
                        popUpTo("welcome") {
                            inclusive = true
                        }
                    }
                },
                onNavigationHome = {
                    navCont.navigate("home") {
                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                },
                selectedItems,
                onRemoveGame = { game ->
                    selectedItems.remove(game)
                })
        }

    }

}
