package com.example.peopleregistercompose.data.repository

import com.example.peopleregistercompose.data.OcupacionDao
import com.example.peopleregistercompose.data.PersonaDao
import com.example.peopleregistercompose.model.Ocupacion
import com.example.peopleregistercompose.model.Persona
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonaRepository @Inject constructor(
    val personaDao: PersonaDao
) {

    suspend fun insertar(persona : Persona){
        personaDao.insertar(persona)
    }

    suspend fun eliminar(persona : Persona){
        personaDao.eliminar(persona)
    }

    /*@Query("""
        SELECT *
        FROM Ocupaciones
        WHERE ocupacionId=:ocupacionId
    """)*/
    fun buscar(personaId: Int): Flow<Persona> {
        return personaDao.buscar(personaId)
    }

    /*@Query("""
        SELECT *
        FROM Ocupaciones
        ORDER BY ocupacionId
    """)*/
    fun getList(): Flow<List<Persona>> {
        return personaDao.getList()
    }
}