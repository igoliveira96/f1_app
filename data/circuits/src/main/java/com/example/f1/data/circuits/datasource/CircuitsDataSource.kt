package com.example.f1.data.circuits.datasource

import com.example.f1.data.circuits.model.Circuit
import kotlinx.coroutines.flow.Flow

interface CircuitsDataSource {

    suspend fun getCircuits(): Flow<Circuit>

}