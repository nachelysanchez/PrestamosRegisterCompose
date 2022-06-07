package com.example.peopleregistercompose.ui.ocupacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.peopleregistercompose.data.repository.OcupacionRepository
import com.example.peopleregistercompose.model.Ocupacion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OcupacionViewModel @Inject constructor(
    val ocupacionRepository : OcupacionRepository
) : ViewModel(){
    var nombre by mutableStateOf("")

    var ocupaciones = ocupacionRepository.getList()
    private set

    fun Guardar(){
        viewModelScope.launch {
            ocupacionRepository.insertar(
                Ocupacion(
                    nombres = nombre
                )
            )
        }
    }
}