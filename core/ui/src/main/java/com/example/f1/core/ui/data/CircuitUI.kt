package com.example.f1.core.ui.data

data class CircuitUI(
    val id: Int,
    val name: String,
    val imageURL: String,
    val laps: Int,
    val competition: CompetitionUI,
    val lapRecordUI: LapRecordUI,
    val length: String,
    val raceDistance: String
) {

    companion object {
        val EXAMPLE = CircuitUI(
            id = 1,
            name = "Albert Park Circuit",
            imageURL = "https://media-4.api-sports.io/formula-1/circuits/1.png",
            laps = 58,
            competition = CompetitionUI.EXAMPLE,
            lapRecordUI = LapRecordUI(
                time = "1:24.125",
                driver = "Michael Schumacher",
                year = "2004"
            ),
            length = "5.303 Kms",
            raceDistance = "307.574 kms"
        )
    }

}
