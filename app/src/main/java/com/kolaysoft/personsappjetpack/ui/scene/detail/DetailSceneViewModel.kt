package com.kolaysoft.personsappjetpack.ui.scene.detail

import android.util.Log
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kolaysoft.personsappjetpack.data.model.Person
import com.kolaysoft.personsappjetpack.data.repo.PersonRepository
import com.kolaysoft.personsappjetpack.ui.scene.home.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailSceneViewModel @Inject constructor(
    private val personRepository: PersonRepository,
) : ViewModel() {


    private val _person = MutableStateFlow<Person?>(null)
    val person: StateFlow<Person?> get() = _person

    fun getPersonById(personId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val person = personRepository.findPersonById(personId)
            _person.value = person
        }
    }

    fun deletePersonById(personId: Int) {
        viewModelScope.launch {
            personRepository.deletePersonById(personId)
        }
    }

}