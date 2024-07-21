package com.example.f1.data.circuits.data.repository

import com.example.f1.data.circuits.datasource.CircuitsDataSource
import com.example.f1.data.circuits.model.Circuit
import com.example.f1.data.circuits.repository.CircuitsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CircuitsRepositoryImpl @Inject constructor(
    private val circuitsDataSource: CircuitsDataSource
) : CircuitsRepository {

    override fun getCircuits(forceUpdate: Boolean): Single<List<Circuit>> =
        circuitsDataSource.getCircuits(forceUpdate)

}