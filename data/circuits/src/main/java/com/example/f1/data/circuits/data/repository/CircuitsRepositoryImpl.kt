package com.example.f1.data.circuits.data.repository

import com.example.f1.data.circuits.datasource.CircuitsDataSource
import com.example.f1.data.circuits.model.Circuit
import com.example.f1.data.circuits.repository.CircuitsRepository
import kotlinx.coroutines.flow.Flow

class CircuitsRepositoryImpl(
    private val circuitsDataSource: CircuitsDataSource
) : CircuitsRepository {

    override suspend fun getCircuits(): Flow<Circuit> =
        circuitsDataSource.getCircuits()

}