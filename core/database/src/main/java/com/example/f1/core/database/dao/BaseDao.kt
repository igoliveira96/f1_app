package com.example.f1.core.database.dao

import kotlinx.coroutines.flow.Flow

interface BaseDao<T> {

    suspend fun findById(id: Int): Flow<T>

    suspend fun findAll(): Flow<List<T>>

    suspend fun insertAll(values: List<T>): Flow<Unit>

}