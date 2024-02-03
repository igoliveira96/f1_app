package com.example.f1.feature.circuits

import com.example.f1.core.data.viewmodel.BaseViewModel
import com.example.f1.data.circuits.usecase.GetCircuitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CircuitsViewModel @Inject constructor(
    private val getCircuitsUseCase: GetCircuitsUseCase
) : BaseViewModel<CircuitsContract.Event, CircuitsContract.State, CircuitsContract.Effect>() {

    init {
        fetchCircuits()
    }

    override fun setInitialState() = CircuitsContract.State(
        isLoading = true,
        circuits = emptyList()
    )

    override fun handleEvents(event: CircuitsContract.Event) {

    }

    private fun fetchCircuits() {
        getCircuitsUseCase(
            onDisposable = { disposable -> disposables.add(disposable) },
            onResult = { result ->
                if (result.isSuccess) {
                    result.getOrNull()?.let { circuits ->
                        setState { copy(circuits = circuits, isLoading = false) }
                    }
                }
            }
        )
    }

}
