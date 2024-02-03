package com.example.f1.core.data.result

import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable

open class F1Observer<T: Any>(
    private val onResult: (F1Result<T>) -> Unit,
    private val onSubscribe: (Disposable) -> Unit
) : SingleObserver<T> {

    override fun onSubscribe(d: Disposable) { }

    override fun onSuccess(data: T) {
        onResult(F1Result.success(data))
    }

    override fun onError(e: Throwable) {
        onResult(F1Result.failure(e))
    }
}
