package com.example.f1.data.circuits.repository

import com.example.f1.data.circuits.model.Circuit
import io.reactivex.rxjava3.core.Single

interface CircuitsRepository {

    fun getCircuits(forceUpdate: Boolean): Single<List<Circuit>>

}