package com.example.f1.data

data class DriverUI(
    val name: String,
    val team: String,
    val number: Int,
    val points: Int,
    val imageURL: String
) {

    val firstName: String
        get() {
            val words = name.trim().split(" ")
            return if (words.isNotEmpty()) {
                words[0]
            } else {
                ""
            }
        }

    val lastName: String
        get() {
            val words = name.trim().split(" ")
            return if (words.isNotEmpty() && words.size > 1) {
                words.last()
            } else {
                ""
            }
        }

    companion object {
        val EXAMPLE = DriverUI(
            name = "Lewis Hamilton",
            team = "Mercedes-AMG Petronas",
            number = 44,
            points = 198,
            imageURL = "https://media.api-sports.io/formula-1/drivers/20.png"
        )
    }

}