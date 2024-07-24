package com.kolaysoft.personsappjetpack.data.repo

import com.kolaysoft.personsappjetpack.data.model.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    suspend fun getAllPersons(): Flow<List<Person>>
    suspend fun addPerson(person: Person)
    suspend fun deletePerson(personId: Int)
    suspend fun findPersonById(personId: Int): Person
    suspend fun deletePersonById(personId: Int)
}