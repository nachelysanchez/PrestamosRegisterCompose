package com.example.peopleregistercompose.ui.personas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.peopleregistercompose.data.repository.PersonaRepository
import com.example.peopleregistercompose.model.Persona
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonaViewModel @Inject constructor(
    val personaRepository: PersonaRepository
) : ViewModel() {
    var nombre by mutableStateOf("")

    var email by mutableStateOf("")

    var ocupacionId by mutableStateOf(0)

    var salario by mutableStateOf(0)

    var personas = personaRepository.getList()
    private set

    fun Guardar(){
        viewModelScope.launch{
            personaRepository.insertar(
                Persona(
                    nombres = nombre,
                    email = email,
                    ocupacionId = ocupacionId,
                    salario = salario.toFloat()
                )
            )
        }
    }
}