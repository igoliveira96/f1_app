package com.example.f1.core.ui.data

data class CompetitionUI(
    val id: Int,
    val name: String,
    val location: LocationUI,
) {

    companion object {
        val EXAMPLE = CompetitionUI(
            id = 1,
            name = "Australia Grand Prix",
            location = LocationUI(
                country = "Australia",
                city = "Melbourne"
            )
        )
    }

}