package com.example.f1.data.circuits.mapper

import com.example.f1.core.data.mapper.BaseMapper
import com.example.f1.data.circuits.data.remote.response.CircuitResponse
import com.example.f1.data.circuits.data.remote.response.CompetitionResponse
import com.example.f1.data.circuits.data.remote.response.LapRecordResponse
import com.example.f1.data.circuits.data.remote.response.LocationResponse
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

    override fun fromDomain(domain: Circuit): CircuitResponse = CircuitResponse(
        id = domain.id,
        name = domain.name,
        image = domain.image,
        firstGrandPrix = domain.firstGrandPrix,
        laps = domain.laps,
        length = domain.length,
        raceDistance = domain.raceDistance,
        lapRecord = LapRecordResponse(
            time = domain.lapRecord.time,
            driver = domain.lapRecord.driver,
            year = domain.lapRecord.year
        ),
        competition = CompetitionResponse(
            id = domain.competition.id,
            name = domain.competition.name,
            location = LocationResponse(
                country = domain.competition.location.country,
                city = domain.competition.location.city
            )
        ),
        capacity = domain.capacity,
        opened = domain.opened,
        owner = domain.owner
    )
}