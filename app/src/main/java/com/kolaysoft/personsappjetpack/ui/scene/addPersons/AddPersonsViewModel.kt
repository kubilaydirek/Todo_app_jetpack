package com.kolaysoft.personsappjetpack.ui.scene.addPersons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kolaysoft.personsappjetpack.data.model.Person
import com.kolaysoft.personsappjetpack.data.repo.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPersonsViewModel @Inject constructor(
    private val personRepository: PersonRepository
) : ViewModel() {

    fun addPerson(person: Person) {
        viewModelScope.launch(Dispatchers.IO) {
            personRepository.addPerson(person)
        }
    }

}