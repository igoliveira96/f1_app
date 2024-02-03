package com.example.f1.core.ui.data

data class LapRecordUI(
    val time: String?,
    val driver: String?,
    val year: String?
) {

    val isEmpty: Boolean
        get() = time.isNullOrEmpty() || driver.isNullOrEmpty() || year.isNullOrEmpty()

}
