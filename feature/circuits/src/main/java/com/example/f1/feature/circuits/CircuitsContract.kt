package com.example.f1.feature.circuits

import com.example.f1.core.data.viewmodel.ViewEvent
import com.example.f1.core.data.viewmodel.ViewSideEffect
import com.example.f1.core.data.viewmodel.ViewState
import com.example.f1.core.ui.data.CircuitUI

class CircuitsContract {

    sealed class Event : ViewEvent

    data class State(
        val isLoading: Boolean,
        val circuits: List<CircuitUI>
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object Back : Navigation()
        }
    }

}