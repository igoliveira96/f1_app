package com.example.f1.core.database.di

import android.content.Context
import com.example.f1.core.database.F1Database
import com.example.f1.core.database.dao.CircuitsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): F1Database {
        return F1Database.createDataBase(appContext)
    }

    @Provides
    fun providesCircuitsDao(appDatabase: F1Database): CircuitsDao =
        appDatabase.circuitsDao()

}