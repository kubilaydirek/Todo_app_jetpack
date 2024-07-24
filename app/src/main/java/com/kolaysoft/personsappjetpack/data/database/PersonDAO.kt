package com.kolaysoft.personsappjetpack.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kolaysoft.personsappjetpack.data.model.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDAO {
    @Insert
    suspend fun addPerson(person: Person)

    @Query("DELETE FROM PersonTable WHERE id = :personId")
    suspend fun deletePerson(personId: Int)

    @Query("SELECT * FROM PersonTable")
    fun getAllPerson(): Flow<List<Person>>

    @Query("SELECT * FROM PersonTable WHERE id = :personId")
    suspend fun findPersonById(personId: Int): Person

    @Query("DELETE FROM PersonTable WHERE id = :personId")
    suspend fun deletePersonById(personId: Int)
}