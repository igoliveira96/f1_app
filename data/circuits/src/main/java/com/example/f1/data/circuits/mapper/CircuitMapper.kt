package com.example.f1.data.circuits.mapper

import com.example.f1.core.data.mapper.BaseMapper
import com.example.f1.data.circuits.data.remote.response.CircuitResponse
import com.example.f1.data.circuits.model.Circuit
import com.example.f1.data.circuits.model.Competition
import com.example.f1.data.circuits.model.LapRecord
import com.example.f1.data.circuits.model.Location

object CircuitMapper : BaseMapper<CircuitResponse, Circuit>() {

    override fun toDomain(data: CircuitResponse) = Circuit(
        id = data.id,
        name = data.name,
        image = data.image,
        firstGrandPrix = data.firstGrandPrix,
        laps = data.laps,
        length = data.length,
        raceDistance = data.raceDistance,
        lapRecord = LapRecord(
            time = data.lapRecord.time,
            driver = data.lapRecord.driver,
            year = data.lapRecord.year
        ),
        competition = Competition(
            id = data.competition.id,
            name = data.competition.name,
            location = Location(
                country = data.competition.location.country,
                city = data.competition.location.city
            )
        ),
        capacity = data.capacity,
        opened = data.opened,
        owner = data.owner
    )
}