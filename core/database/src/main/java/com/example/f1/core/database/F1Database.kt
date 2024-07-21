package com.example.f1.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.f1.core.database.dao.CircuitsDao
import com.example.f1.core.database.data.CircuitEntity

@Database(
    version = 1,
    entities = [
        CircuitEntity::class
    ]
)
abstract class F1Database : RoomDatabase() {

    abstract fun circuitsDao(): CircuitsDao

    companion object {
        fun createDataBase(context: Context) : F1Database {
            return Room
                .databaseBuilder(context, F1Database::class.java, "f1_database.db")
                .build()
        }
    }

}