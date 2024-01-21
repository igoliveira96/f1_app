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
) {

    companion object {
        val ALBERT_PARK_CIRCUIT = Circuit(
            id = 1,
            name = "Albert Park Circuit",
            image = "https://media-4.api-sports.io/formula-1/circuits/1.png",
            laps = 58,
            lapRecord = LapRecord(
                time = "1:24.125",
                driver = "Michael Schumacher",
                year = "2004"
            ),
            length = "5.303 Kms",
            raceDistance = "307.574 kms",
            capacity = 0,
            opened = 1990,
            owner = null,
            firstGrandPrix = 1990
        )

        val BAHRAIN = Circuit(
            id = 2,
            name = "Bahrain International Circuit",
            image = "https://media-4.api-sports.io/formula-1/circuits/2.png",
            firstGrandPrix = 2004,
            laps = 57,
            length = "5.412 Kms",
            raceDistance = "308.238 kms",
            lapRecord = LapRecord(
                time = "1:31.447",
                driver = "Pedro de la Rosa",
                year = "2005"
            ),
            capacity = 70000,
            opened = 2004,
            owner = null
        )

        val CIRCUITS_EXAMPLE = listOf(ALBERT_PARK_CIRCUIT, BAHRAIN)
    }

}

data class LapRecord(
    val time: String,
    val driver: String,
    val year: String
)