package com.example.f1.feature.circuits

import androidx.lifecycle.ViewModel
import com.example.f1.data.circuits.rxjava.RxJavaExample
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class CircuitsViewModel @Inject constructor() : ViewModel() {

    private val disposables = CompositeDisposable()

    init {
        fetchCircuits()
    }

    private fun fetchCircuits() {
        RxJavaExample().testRxJava()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}