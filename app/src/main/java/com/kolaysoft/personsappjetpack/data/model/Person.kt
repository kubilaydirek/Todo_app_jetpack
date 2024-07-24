package com.kolaysoft.personsappjetpack.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PersonTable")
data class Person(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val firsName: String,
    val lastName: String,
    val phoneNumber: String,
    val address: String,
    val isFavorited: Boolean? = false
)
