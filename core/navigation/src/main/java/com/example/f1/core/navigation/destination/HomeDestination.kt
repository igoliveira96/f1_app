package com.example.f1.core.navigation.destination

object HomeDestination {

    object Racing : ChildDestination(parent = ParentDestination.Home, route = "racing")
    object Circuits : ChildDestination(parent = ParentDestination.Home, route = "circuits")
    object Standings : ChildDestination(parent = ParentDestination.Home, route = "standings")

}