package com.example.f1.data.circuits.data.remote.services

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {

    @Singleton
    @Provides
    fun providesCircuitsService(retrofit: Retrofit): CircuitsService =
        retrofit.create(CircuitsService::class.java)

}