package com.example.peopleregistercompose.di

import android.content.Context
import androidx.room.Room
import com.example.peopleregistercompose.data.OcupacionDao
import com.example.peopleregistercompose.data.PersonaDao
import com.example.peopleregistercompose.data.PrestamosDb
import com.example.peopleregistercompose.data.repository.OcupacionRepository
import com.example.peopleregistercompose.data.repository.PersonaRepository
import com.example.peopleregistercompose.model.Ocupacion
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun ProvideTicketDb(@ApplicationContext context: Context): PrestamosDb {
        val DATABASE_NAME = "PrestamosDb"
        return Room.databaseBuilder(
            context,
            PrestamosDb::class.java,
            DATABASE_NAME       )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvidePersonaDAO(prestamosDb: PrestamosDb): PersonaDao {
        return prestamosDb.personaDao
    }

    @Provides
    fun ProvideOcupacionDAO(prestamosDb: PrestamosDb): OcupacionDao {
        return prestamosDb.ocupacionDao
    }
    @Provides
    fun provideOcupacionRepository(ocupaciondao: OcupacionDao) : OcupacionRepository{
        return OcupacionRepository(ocupaciondao)
    }
    @Provides
    fun providePersonaRepository(personaDao: PersonaDao) : PersonaRepository{
        return PersonaRepository(personaDao)
    }
}