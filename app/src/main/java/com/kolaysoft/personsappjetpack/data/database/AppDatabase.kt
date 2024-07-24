package com.kolaysoft.personsappjetpack.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kolaysoft.personsappjetpack.data.model.Person

@Database(entities = [Person::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val dao: PersonDAO
}