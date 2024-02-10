@file:Suppress("FunctionNaming")

package com.example.f1.feature.circuits.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.f1.core.data.viewmodel.SIDE_EFFECTS_KEY
import com.example.f1.core.ui.components.Circuit
import com.example.f1.core.ui.components.FullLoadingView
import com.example.f1.core.ui.components.PageTitle
import com.example.f1.core.ui.data.CircuitUI
import com.example.f1.core.ui.data.CompetitionUI
import com.example.f1.core.ui.data.LapRecordUI
import com.example.f1.core.ui.data.LocationUI
import com.example.f1.core.ui.theme.values.LocalSpacing
import com.example.f1.feature.circuits.CircuitsContract
import com.example.f1.feature.circuits.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun CircuitsScreen(
    state: CircuitsContract.State,
    effectFlow: Flow<CircuitsContract.Effect>?,
    onNavigationRequested: (CircuitsContract.Effect.Navigation) -> Unit
) {
    val spacing = LocalSpacing.current

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.onEach { effect ->
            when (effect) {
                CircuitsContract.Effect.Navigation.Back -> {
                    onNavigationRequested(CircuitsContract.Effect.Navigation.Back)
                }
            }
        }?.collect()
    }

    when {
        state.isLoading -> FullLoadingView()
        else -> {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(spacing.mediumSmall)
            ) {
                item {
                    PageTitle(
                        modifier = Modifier.padding(top = spacing.medium),
                        title = R.string.circuits
                    )
                }

                items(state.circuits) { circuitUI ->
                    Circuit(circuitUI)
                }

            }
        }
    }

}