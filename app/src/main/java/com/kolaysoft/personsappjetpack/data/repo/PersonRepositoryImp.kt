package com.kolaysoft.personsappjetpack.data.repo

import com.kolaysoft.personsappjetpack.data.database.PersonDAO
import com.kolaysoft.personsappjetpack.data.model.Person
import kotlinx.coroutines.flow.Flow

class PersonRepositoryImp(private val dao: PersonDAO) : PersonRepository {
    override suspend fun getAllPersons(): Flow<List<Person>> {
        return dao.getAllPerson()
    }

    override suspend fun addPerson(person: Person) {
        dao.addPerson(person)
    }

    override suspend fun deletePerson(personId: Int) {
        dao.deletePerson(personId)
    }

    override suspend fun findPersonById(personId: Int): Person {
        return dao.findPersonById(personId)
    }

    override suspend fun deletePersonById(personId: Int) {
        dao.deletePersonById(personId)
    }


}