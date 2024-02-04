package com.example.f1.data.circuits.data.datasource

import com.example.f1.core.database.dao.CircuitsDao
import com.example.f1.data.circuits.data.remote.services.CircuitsService
import com.example.f1.data.circuits.datasource.CircuitsDataSource
import com.example.f1.data.circuits.mapper.CircuitEntityMapper
import com.example.f1.data.circuits.mapper.CircuitMapper
import com.example.f1.data.circuits.model.Circuit
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CircuitsDataSourceImpl @Inject constructor(
    private val circuitsService: CircuitsService,
    private val circuitsDao: CircuitsDao
) : CircuitsDataSource {

    override fun getCircuits(forceUpdate: Boolean): Single<List<Circuit>> {
        return if (forceUpdate)
            getCircuitsRemote(forceUpdate)
        else
            circuitsDao.getCircuits()
                .flatMap { circuits ->
                    when{
                        circuits.isEmpty() -> getCircuitsRemote(false)
                        else -> Single.just(CircuitEntityMapper.toDomain(circuits))
                    }
                }
    }

    private fun getCircuitsRemote(isUpdate: Boolean): Single<List<Circuit>> {
        return circuitsService.getCircuits()
            .flatMap { baseResponse ->
                if (isUpdate)
                    circuitsDao.updateData(
                        CircuitEntityMapper.fromDomain(
                            CircuitMapper.toDomain(baseResponse.response)
                        )
                    )
                else
                    circuitsDao.insertAll(
                        CircuitEntityMapper.fromDomain(
                            CircuitMapper.toDomain(baseResponse.response)
                        )
                    )
                Single.just(CircuitMapper.toDomain(baseResponse.response))
            }
    }

}