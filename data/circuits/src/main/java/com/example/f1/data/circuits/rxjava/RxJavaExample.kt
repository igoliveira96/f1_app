package com.example.f1.data.circuits.rxjava

import android.util.Log
import com.example.f1.data.circuits.model.Circuit
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

const val TAG = "RxJavaExample"

class RxJavaExample {

    fun testRxJava() {
        val circuitsObservable = Observable
            .fromIterable(Circuit.CIRCUITS_EXAMPLE)
            .subscribeOn(Schedulers.io())
            .filter { circuit ->
                Thread.sleep(1_000)
                listOf(1, 2, 3).contains(circuit.id)
            }
            .observeOn(AndroidSchedulers.mainThread())

        circuitsObservable.subscribe(object : Observer<Circuit> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: called.")
            }

            override fun onNext(circuit: Circuit) {
                Log.d(TAG, "onNext: ${Thread.currentThread().name}")
                Log.d(TAG, "onNext: ${circuit.name}")
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError: ${e.message}")
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete: called.")
            }
        })
    }

}