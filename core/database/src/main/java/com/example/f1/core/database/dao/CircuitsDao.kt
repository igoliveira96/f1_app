package com.example.f1.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.f1.core.database.data.CircuitEntity
import io.reactivex.rxjava3.core.Single

@Dao
interface CircuitsDao {

    @Query("SELECT * FROM circuits")
    fun getCircuits(): Single<List<CircuitEntity>>

    @Transaction
    fun updateData(circuits: List<CircuitEntity>) {
        deleteAll()
        insertAll(circuits)
    }

    @Insert
    fun insertAll(users: List<CircuitEntity>)

    @Query("DELETE FROM circuits")
    fun deleteAll()

}