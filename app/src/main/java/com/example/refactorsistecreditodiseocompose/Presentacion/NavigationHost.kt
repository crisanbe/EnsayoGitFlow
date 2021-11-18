package com.example.refactorsistecreditodiseocompose.Presentacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.refactorsistecreditodiseocompose.OnBoarding.onBoarding
import com.example.refactorsistecreditodiseocompose.Presentacion.Destinations.Pantalla1
import com.example.refactorsistecreditodiseocompose.Presentacion.Destinations.PantallaLogin
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun NavigationHost() {
     val navController = rememberNavController()

     NavHost(navController = navController, startDestination = Pantalla1.route){
       composable(Pantalla1.route){
           onBoarding(
               PantallaLogin = {
                   navController.navigate(PantallaLogin.route)
               }
           )
       }
         composable(PantallaLogin.route,){
             PantallaLogin()

         }
     }
}