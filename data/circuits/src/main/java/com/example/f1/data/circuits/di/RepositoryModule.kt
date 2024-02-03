package com.example.f1.data.circuits.di

import com.example.f1.data.circuits.data.repository.CircuitsRepositoryImpl
import com.example.f1.data.circuits.repository.CircuitsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Singleton
    @Provides
    fun providesCircuitsRepository(
        impl: CircuitsRepositoryImpl
    ): CircuitsRepository = impl

}