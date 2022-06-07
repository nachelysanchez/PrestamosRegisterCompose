package com.example.peopleregistercompose.utils

sealed class Screen (val route : String){

    object RegistroPersonaScreen : Screen("RegistroPersonas")
    object RegistroOcupacionesScreen : Screen("RegistroOcupaciones")
    object ConsultaPersonaScreen : Screen("ConsultaPersonas")
    object ConsultaOcupacionScreen : Screen("ConsultaOcupacion")
}