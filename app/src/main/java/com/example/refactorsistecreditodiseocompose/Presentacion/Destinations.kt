package com.example.refactorsistecreditodiseocompose.Presentacion

sealed class  Destinations(
    val route: String
)  {
    object Pantalla1: Destinations("pantalla1")
    object PantallaLogin: Destinations("pantallalogin")
}