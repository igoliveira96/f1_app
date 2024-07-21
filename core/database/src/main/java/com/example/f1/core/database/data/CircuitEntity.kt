package com.example.f1.core.database.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "circuits")
data class CircuitEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val image: String,
    @ColumnInfo(name = "first_grand_prix") val firstGrandPrix: Int,
    val laps: Int,
    val length: String,
    @ColumnInfo(name = "race_distance") val raceDistance: String,
    @Embedded val lapRecord: LapRecordEntity,
    @Embedded val competition: CompetitionEntity,
    val capacity: Int,
    val opened: Int,
    val owner: String?
)

data class LapRecordEntity(
    @ColumnInfo(name = "lap_record_time") val time: String?,
    @ColumnInfo(name = "lap_record_driver") val driver: String?,
    @ColumnInfo(name = "lap_record_year") val year: String?
)

data class CompetitionEntity(
    @ColumnInfo(name = "competition_id") val id: Int,
    @ColumnInfo(name = "competition_name") val name: String,
    @Embedded val location: LocationEntity
)

data class LocationEntity(
    @ColumnInfo(name = "location_country") val country: String?,
    @ColumnInfo(name = "location_city") val city: String?
)
