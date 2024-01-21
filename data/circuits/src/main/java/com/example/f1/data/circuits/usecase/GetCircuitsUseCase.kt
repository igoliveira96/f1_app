package com.example.f1.data.circuits.usecase

import com.example.f1.data.circuits.repository.CircuitsRepository
import javax.inject.Inject

class GetCircuitsUseCase @Inject constructor(
    val repository: CircuitsRepository
) {

}