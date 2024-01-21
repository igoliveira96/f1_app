package com.example.f1.core.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.f1.core.navigation.destination.HomeDestination
import com.example.f1.core.navigation.destination.ParentDestination
import com.example.f1.feature.circuits.CircuitsScreen

fun NavGraphBuilder.addHomeNavGraph() {
    navigation(
        route = ParentDestination.Home.route,
        startDestination = HomeDestination.Racing.createRoute()
    ) {
        addRacing()
        addCircuits()
        addStandings()
    }
}

private fun NavGraphBuilder.addRacing() {
    composable(HomeDestination.Racing.createRoute()) {
        Column {
            Text(text = "racing")
        }
    }
}

private fun NavGraphBuilder.addCircuits() {
    composable(HomeDestination.Circuits.createRoute()) {
        CircuitsScreen(viewModel = viewModel())
    }
}

private fun NavGraphBuilder.addStandings() {
    composable(HomeDestination.Standings.createRoute()) {
        Column {
            Text(text = "standings")
        }
    }
}