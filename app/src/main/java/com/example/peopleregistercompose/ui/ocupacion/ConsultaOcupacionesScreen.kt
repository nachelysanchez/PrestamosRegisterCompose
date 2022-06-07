package com.example.peopleregistercompose.ui.ocupacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.peopleregistercompose.RowOcupacion

@Composable
fun ConsultaOcupacionesScreen(
    navHostController: NavHostController,
    viewModel : OcupacionViewModel = hiltViewModel()
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Consulta de Ocupaciones") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate("RegistroOcupaciones")
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    ) {

        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)) {

            val lista = viewModel.ocupaciones.collectAsState(initial = emptyList())

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(lista.value){
                    ocupacion -> RowOcupacion(ocupacion = ocupacion)
                }

            }


        }
    }

}