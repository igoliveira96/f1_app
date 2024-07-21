package com.example.f1.data.circuits.datasource

import com.example.f1.data.circuits.model.Circuit
import io.reactivex.rxjava3.core.Single

interface CircuitsDataSource {

    fun getCircuits(forceUpdate: Boolean): Single<List<Circuit>>

}