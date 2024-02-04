package com.example.f1.data.circuits.mapper

import com.example.f1.core.data.mapper.BaseMapper
import com.example.f1.core.database.data.CircuitEntity
import com.example.f1.core.database.data.CompetitionEntity
import com.example.f1.core.database.data.LapRecordEntity
import com.example.f1.core.database.data.LocationEntity
import com.example.f1.data.circuits.model.Circuit
import com.example.f1.data.circuits.model.Competition
import com.example.f1.data.circuits.model.LapRecord
import com.example.f1.data.circuits.model.Location

object CircuitEntityMapper : BaseMapper<CircuitEntity, Circuit>() {

    override fun toDomain(data: CircuitEntity): Circuit = Circuit(
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

    override fun fromDomain(domain: Circuit): CircuitEntity = CircuitEntity(
        id = domain.id,
        name = domain.name,
        image = domain.image,
        firstGrandPrix = domain.firstGrandPrix,
        laps = domain.laps,
        length = domain.length,
        raceDistance = domain.raceDistance,
        lapRecord = LapRecordEntity(
            time = domain.lapRecord.time,
            driver = domain.lapRecord.driver,
            year = domain.lapRecord.year
        ),
        competition = CompetitionEntity(
            id = domain.competition.id,
            name = domain.competition.name,
            location = LocationEntity(
                country = domain.competition.location.country,
                city = domain.competition.location.city
            )
        ),
        capacity = domain.capacity,
        opened = domain.opened,
        owner = domain.owner
    )
}