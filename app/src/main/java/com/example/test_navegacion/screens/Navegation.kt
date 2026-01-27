package com.example.test_navegacion.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.Navigation
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){

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
                {nController.navigate("denied")}
            )
        }
        composable("home"){
            //Teniendo en principio dos pantallas, popBackStack elimina la última
            //de la pila -> en este caso siempre "home"
            HomeScreen({nController.popBackStack() })
        }
        composable("denied"){
            DeniedScreen({nController.popBackStack()})
        }

    }

}