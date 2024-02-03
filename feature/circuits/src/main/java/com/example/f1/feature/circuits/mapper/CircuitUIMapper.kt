package com.example.f1.feature.circuits.mapper

import com.example.f1.core.data.mapper.BaseMapper
import com.example.f1.core.ui.data.CircuitUI
import com.example.f1.core.ui.data.CompetitionUI
import com.example.f1.core.ui.data.LapRecordUI
import com.example.f1.core.ui.data.LocationUI
import com.example.f1.data.circuits.model.Circuit

object CircuitUIMapper : BaseMapper<Circuit, CircuitUI>() {

    override fun toDomain(data: Circuit) = CircuitUI(
        id = data.id,
        name = data.name,
        imageURL = data.image,
        laps = data.laps,
        competition = CompetitionUI(
            id = data.competition.id,
            name = data.competition.name,
            location = LocationUI(
                country = data.competition.location.country,
                city = data.competition.location.city,
            )
        ),
        lapRecordUI = LapRecordUI(
            time = data.lapRecord.time,
            driver = data.lapRecord.driver,
            year = data.lapRecord.year,
        ),
        length = data.length,
        raceDistance = data.raceDistance
    )
}