package com.example.f1.data.circuits.di

import com.example.f1.data.circuits.data.datasource.CircuitsDataSourceImpl
import com.example.f1.data.circuits.datasource.CircuitsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun providesCircuitsDataSource(
        impl: CircuitsDataSourceImpl
    ): CircuitsDataSource = impl

}