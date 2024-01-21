package com.example.f1.data.circuits.model

data class Circuit(
    val id: Int,
    val name: String,
    val image: String,
    val firstGrandPrix: Int,
    val laps: Int,
    val length: String,
    val raceDistance: String,
    val lapRecord: LapRecord,
    val capacity: Int,
    val opened: Int,
    val owner: String?
)

data class LapRecord(
    val time: String,
    val driver: String,
    val year: String
)