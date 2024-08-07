package com.example.f1.feature.circuits.viewmodel

import com.example.f1.core.data.viewmodel.BaseViewModel
import com.example.f1.data.circuits.usecase.GetCircuitsUseCase
import com.example.f1.feature.circuits.mapper.CircuitUIMapper
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

    override fun handleEvents(event: CircuitsContract.Event) = Unit

    private fun fetchCircuits() {
        getCircuitsUseCase(
            params = GetCircuitsUseCase.Params(
                forceUpdate = false
            ),
            onDisposable = { disposable -> disposables.add(disposable) },
            onResult = { result ->
                if (result.isSuccess) {
                    result.getOrNull()?.let { circuits ->
                        setState {
                            copy(
                                circuits = CircuitUIMapper.toUI(circuits),
                                isLoading = false
                            )
                        }
                    }
                }
            }
        )
    }

}
