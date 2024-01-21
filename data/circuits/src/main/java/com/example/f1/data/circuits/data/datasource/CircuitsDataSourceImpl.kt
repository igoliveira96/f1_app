package com.example.f1.data.circuits.data.datasource

import com.example.f1.core.database.dao.CircuitsDao
import com.example.f1.data.circuits.datasource.CircuitsDataSource
import com.example.f1.data.circuits.model.Circuit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class CircuitsDataSourceImpl @Inject constructor(
    private val circuitsDao: CircuitsDao
) : CircuitsDataSource {

    override suspend fun getCircuits(): Flow<Circuit> = flow {

    }

}