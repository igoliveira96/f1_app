package com.example.f1.data.circuits.repository

import com.example.f1.data.circuits.model.Circuit
import kotlinx.coroutines.flow.Flow

interface CircuitsRepository {

    suspend fun getCircuits(): Flow<Circuit>

}