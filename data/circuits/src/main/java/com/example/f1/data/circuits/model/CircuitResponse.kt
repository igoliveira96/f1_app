package com.example.f1.data.circuits.model

import com.google.gson.annotations.SerializedName

data class CircuitResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("first_grand_prix") val firstGrandPrix: Int,
    @SerializedName("laps") val laps: Int,
    @SerializedName("length") val length: String,
    @SerializedName("race_distance") val raceDistance: String,
    @SerializedName("lap_record") val lapRecord: LapRecordResponse,
    @SerializedName("capacity") val capacity: Int,
    @SerializedName("opened") val opened: Int,
    @SerializedName("owner") val owner: String?
)

data class LapRecordResponse(
    @SerializedName("time") val time: String,
    @SerializedName("driver") val driver: String,
    @SerializedName("year") val year: String
)
