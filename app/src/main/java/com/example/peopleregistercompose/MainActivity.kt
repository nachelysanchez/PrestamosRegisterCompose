package com.example.peopleregistercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.peopleregistercompose.ui.theme.PeopleRegisterComposeTheme


var selectedOcupacion: String? = null

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PeopleRegisterComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "ConsultaPersonas"){
        composable("ConsultaOcupaciones"){
            ConsultaOcupacionesScreen(navHostController = navHostController)
        }
        composable("RegistroOcupaciones"){
            RegistroOcupacionesScreen(navHostController = navHostController)
        }
        composable("ConsultaPersonas"){
            ConsultaPersonaScreen(navHostController = navHostController)
        }
        composable("RegistroPersona"){
            RegistroPersonaScreen(navHostController = navHostController)
        }
    }
}

@Composable
fun ConsultaOcupacionesScreen(navHostController: NavHostController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Consulta de Ocupaciones")}
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
        Column(modifier = Modifier.padding(8.dp)) {

            val lista = listOf("Maestro", "Ingeniero", "Doctor", "Carpinterio")

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(lista){
                        ocupacion -> RowOcupacion(ocupacion = ocupacion)
                }
            }


        }
    }

}

@Composable
fun RegistroOcupacionesScreen(navHostController: NavHostController){
    var ocupacion by rememberSaveable(){
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = ocupacion,
            onValueChange = {ocupacion = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nombre de la Ocupaci~n")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null)
            }
        )



        OutlinedButton(onClick = { navHostController.navigateUp() }) {
            Text(text = "Guardar")
        }
    }
}

@Composable
fun ConsultaPersonaScreen(navHostController: NavHostController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Consulta de Personas")}
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate("RegistroPersona")
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Button(onClick = { navHostController.navigate("ConsultaOcupaciones") }) {
                Text(text = "Nueva Ocupación")
            }
            val lista = listOf("Kelvin", "Alvaro", "Nachely", "Vismar", "Enel", "Junior")

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(lista){
                        nombre -> RowPersona(nombre = nombre)
                }
            }
        }
    }

}

@Composable
fun RegistroPersonaScreen(navHostController: NavHostController){
    var person by rememberSaveable(){
        mutableStateOf("")
    }

    val ocup = listOf("Maestro", "Ingeniero", "Doctor", "Carpinterio")
    Column(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = person,
            onValueChange = {person = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nombre de la Persona")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null)
            }
        )

        OutlinedTextField(
            value = person,
            onValueChange = {person = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null)
            }
        )

        OcupacionesSpinner(ocupacion = ocup)

        OutlinedTextField(
            value = person,
            onValueChange = {person = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Salario")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null)
            }
        )

        OutlinedButton(onClick = { navHostController.navigateUp() }) {
            Text(text = "Guardar")
        }
    }
}

@Composable
fun OcupacionesSpinner(ocupacion:List<String>){

    var ocupacionText by remember{
        mutableStateOf("")
    }
    var expended by remember{
        mutableStateOf(false)
    }
    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(Modifier
            .fillMaxWidth()
            .clickable {
                expended = !expended
            }
            .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){

            Text(text = ocupacionText, fontSize = 18.sp, modifier = Modifier.padding(end = 8.dp))
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
            DropdownMenu(expanded = expended, onDismissRequest = { expended = false}) {
                ocupacion.forEach {
                    ocupacion -> DropdownMenuItem(onClick = {

                        expended = false
                    ocupacionText = ocupacion.toString()
                    selectedOcupacion = ocupacion
                }) {
                        Text(text = ocupacion.toString())
                }
                }

            }
        }
    }
}

@Composable
fun RowPersona(nombre:String){
    Row() {
        Text(text = "El nombre es: $nombre")
    }
}

@Composable
fun RowOcupacion(ocupacion:String){
    Row() {
        Text(text = "El nombre de la Ocupación es: $ocupacion")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PeopleRegisterComposeTheme {
        MyApp()
    }
}