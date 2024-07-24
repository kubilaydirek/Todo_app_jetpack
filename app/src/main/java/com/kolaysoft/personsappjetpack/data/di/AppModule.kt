package com.kolaysoft.personsappjetpack.data.di

import android.app.Application
import androidx.room.Room
import com.kolaysoft.personsappjetpack.data.database.AppDatabase
import com.kolaysoft.personsappjetpack.data.repo.PersonRepository
import com.kolaysoft.personsappjetpack.data.repo.PersonRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "AppDatabase").build()
    }

    @Singleton
    @Provides
    fun providePersonRepository(db: AppDatabase): PersonRepository {
        return PersonRepositoryImp(db.dao)
    }
}