package com.example.test_navegacion.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.Navigation
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.test_navegacion.data.Videogame

@Composable
fun Navigation(lgames : List<Videogame>){

    //Variable de navControler para controlar navegación entre páginas
    val nController = rememberNavController() //remember(?)

    //Componente que controla rutas de navegación (como un mapa)
    NavHost(
        navController = nController,
        startDestination = "welcome"
    )
    {

        composable("welcome") //route = id de la pantalla donde navegamos
        {
            WelcomeScreen(
                //busca el id "home" y crea un composable de tipo HomeScreen
                { nController.navigate("home")},
                {nController.navigate("denied")},
            )
        }

        //TODO: IMPORT
        composable("home"){
            //Teniendo en principio dos pantallas, popBackStack elimina la última
            //de la pila -> en este caso siempre "home"
            HomeScreen(
                //Reset
                {nController.popBackStack() },
                //Detalles -> id concreto del juego que queremos ver
                { id -> nController.navigate("detail/$id")},
                //Compra
                {nController.navigate("buy")},
                lgames
            )
        }


        composable("denied"){
            DeniedScreen(
                {nController.popBackStack()}
            )
        }
        composable("detail/{id}", listOf(navArgument("id") { type = NavType.StringType})
        ){
            //documentar funcionamiento, rarete
            backStackEntry ->
            val id =  backStackEntry.arguments?.getString("id")

            val selected = lgames.find { it.nombre == id }

            selected?.let{
                game ->
                DetailScreen(
                    game = game,
                    onNavigateToHome = {nController.popBackStack()}
                ){}
            }

        }


        composable("buy"){
            BuyScreen(
                {nController.navigate("home")},
                {nController.navigate("detail")},
                {nController.navigate("welcome")}
            )
        }
    }

}