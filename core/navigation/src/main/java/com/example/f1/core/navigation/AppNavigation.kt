@file:Suppress("FunctionNaming")

package com.example.f1.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.f1.core.navigation.destination.ParentDestination

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ParentDestination.Home.route
    ) {
        addHomeNavGraph()
    }
}
