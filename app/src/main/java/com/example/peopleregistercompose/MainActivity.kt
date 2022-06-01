package com.example.peopleregistercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    RegistroPersonaScreen()
}

@Composable
fun ConsultaPersonaScreen(){
    Column(modifier = Modifier.padding(8.dp)) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Nuevo")
        }
        val lista = listOf("Kelvin", "Alvaro", "Nachely", "Vismar", "Enel", "Junior")

        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(lista){
                nombre -> RowPersona(nombre = nombre)
            }
        }
    }
}

@Composable
fun RegistroPersonaScreen(){
    val ocup = listOf("Maestro", "Ingeniero", "Doctor", "Carpinterio")
    Column(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
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
            value = "",
            onValueChange = {},
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
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Personas")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null)
            }
        )
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
            .padding(24.dp)
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PeopleRegisterComposeTheme {
        MyApp()
    }
}