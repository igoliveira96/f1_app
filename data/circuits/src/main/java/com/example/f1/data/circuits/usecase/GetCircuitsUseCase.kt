package com.example.f1.data.circuits.usecase

import com.example.f1.core.data.usecase.BaseUseCaseRxJava
import com.example.f1.data.circuits.model.Circuit
import com.example.f1.data.circuits.repository.CircuitsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetCircuitsUseCase @Inject constructor(
    private val repository: CircuitsRepository
) : BaseUseCaseRxJava<List<Circuit>, GetCircuitsUseCase.Params>() {

    override fun execute(params: Params?): Single<List<Circuit>> =
        repository.getCircuits()

    class Params

}