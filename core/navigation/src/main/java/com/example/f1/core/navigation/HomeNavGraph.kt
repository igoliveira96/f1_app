package com.example.f1.core.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.f1.core.navigation.destination.HomeDestination
import com.example.f1.core.navigation.destination.ParentDestination
import com.example.f1.feature.circuits.CircuitsContract
import com.example.f1.feature.circuits.CircuitsViewModel
import com.example.f1.feature.circuits.ui.CircuitsScreen

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
        val viewModel: CircuitsViewModel = hiltViewModel()
        CircuitsScreen(
            state = viewModel.viewState.value,
            effectFlow = viewModel.effect,
//            onEventSent = { event ->  viewModel.setEvent(event) },
            onNavigationRequested = { navigationEffect ->
                if (navigationEffect is CircuitsContract.Effect.Navigation.Back) {
//                    navController.navigateToRepos(navigationEffect.userId)
                }
            }
        )
    }
}

private fun NavGraphBuilder.addStandings() {
    composable(HomeDestination.Standings.createRoute()) {
        Column {
            Text(text = "standings")
        }
    }
}
