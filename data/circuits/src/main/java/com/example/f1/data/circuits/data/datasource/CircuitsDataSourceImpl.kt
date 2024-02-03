package com.example.f1.data.circuits.data.datasource

import com.example.f1.data.circuits.data.remote.services.CircuitsService
import com.example.f1.data.circuits.datasource.CircuitsDataSource
import com.example.f1.data.circuits.model.Circuit
import com.example.f1.data.circuits.model.Competition
import com.example.f1.data.circuits.model.LapRecord
import com.example.f1.data.circuits.model.Location
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CircuitsDataSourceImpl @Inject constructor(
    private val circuitsService: CircuitsService
) : CircuitsDataSource {

    override fun getCircuits(): Single<List<Circuit>> {
        return circuitsService.getCircuits().map { baseResponse ->
            baseResponse.response.map { circuitResponse ->
                Circuit(
                    id = circuitResponse.id,
                    name = circuitResponse.name,
                    image = circuitResponse.image,
                    firstGrandPrix = circuitResponse.firstGrandPrix,
                    laps = circuitResponse.laps,
                    length = circuitResponse.length,
                    raceDistance = circuitResponse.raceDistance,
                    lapRecord = LapRecord(
                        time = circuitResponse.lapRecord.time,
                        driver = circuitResponse.lapRecord.driver,
                        year = circuitResponse.lapRecord.year
                    ),
                    competition = Competition(
                        id = circuitResponse.competition.id,
                        name = circuitResponse.competition.name,
                        location = Location(
                            country = circuitResponse.competition.location.country,
                            city = circuitResponse.competition.location.city
                        )
                    ),
                    capacity = circuitResponse.capacity,
                    opened = circuitResponse.opened,
                    owner = circuitResponse.owner
                )
            }
        }
    }

}