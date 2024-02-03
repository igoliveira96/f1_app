package com.example.f1.core.navigation.destination

sealed class ParentDestination(val route: String) {
    object Home : ParentDestination("home")
}

sealed class ChildDestination(
    private val parent: ParentDestination,
    private val route: String,
) {
    fun createRoute() = "${parent.route}/$route"
}
