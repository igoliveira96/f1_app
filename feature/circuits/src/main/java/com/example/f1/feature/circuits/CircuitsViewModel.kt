package com.example.f1.feature.circuits

import androidx.lifecycle.ViewModel
import com.example.f1.data.circuits.rxjava.RxJavaExample
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CircuitsViewModel @Inject constructor() : ViewModel() {

    init {
        fetchCircuits()
    }

    private fun fetchCircuits() {
        RxJavaExample().testRxJava()
    }

}