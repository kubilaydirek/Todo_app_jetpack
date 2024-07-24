package com.kolaysoft.personsappjetpack.ui.scene.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kolaysoft.personsappjetpack.data.model.Person
import com.kolaysoft.personsappjetpack.data.repo.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val personRepository: PersonRepository
) : ViewModel() {
    init {
        getAllContact()
    }

    private val _data = MutableStateFlow(emptyList<Person>())
    val data = _data.asStateFlow()


     private fun getAllContact() {
        viewModelScope.launch {
            personRepository.getAllPersons().collectLatest {
                _data.tryEmit(it)
            }
        }
    }
}