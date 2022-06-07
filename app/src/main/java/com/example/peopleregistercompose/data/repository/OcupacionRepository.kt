package com.example.peopleregistercompose.data.repository

import com.example.peopleregistercompose.data.OcupacionDao
import com.example.peopleregistercompose.model.Ocupacion
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OcupacionRepository @Inject constructor(
    val ocupacionDao: OcupacionDao
) {

    suspend fun insertar(ocupacion : Ocupacion){
        ocupacionDao.insertar(ocupacion)
    }

    suspend fun eliminar(ocupacion : Ocupacion){
        ocupacionDao.eliminar(ocupacion)
    }

    /*@Query("""
        SELECT * 
        FROM Ocupaciones
        WHERE ocupacionId=:ocupacionId
    """)*/
    fun buscar(ocupacionId: Int): Flow<Ocupacion>{
        return ocupacionDao.buscar(ocupacionId)
    }

    /*@Query("""
        SELECT * 
        FROM Ocupaciones
        ORDER BY ocupacionId    
    """)*/
    fun getList(): Flow<List<Ocupacion>>{
        return ocupacionDao.getList()
    }
}
