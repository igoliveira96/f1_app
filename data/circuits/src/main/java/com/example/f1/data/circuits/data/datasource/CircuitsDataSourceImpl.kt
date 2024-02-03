package com.example.f1.data.circuits.data.datasource

import com.example.f1.data.circuits.data.remote.services.CircuitsService
import com.example.f1.data.circuits.datasource.CircuitsDataSource
import com.example.f1.data.circuits.mapper.CircuitMapper
import com.example.f1.data.circuits.model.Circuit
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CircuitsDataSourceImpl @Inject constructor(
    private val circuitsService: CircuitsService
) : CircuitsDataSource {

    override fun getCircuits(): Single<List<Circuit>> {
        return circuitsService.getCircuits().map { result ->
            CircuitMapper.toDomain(result.response)
        }
    }

}