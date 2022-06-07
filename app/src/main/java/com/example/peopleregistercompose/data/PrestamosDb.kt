package com.example.peopleregistercompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.peopleregistercompose.model.Ocupacion
import com.example.peopleregistercompose.model.Persona

@Database(
    entities = [
        Ocupacion::class,
        Persona::class
    ],
    exportSchema = false,
    version = 1
)
abstract class PrestamosDb : RoomDatabase() {
    abstract val ocupacionDao:OcupacionDao
    abstract val personaDao: PersonaDao
}