package com.example.f1.core.data.usecase

import com.example.f1.core.data.result.F1Observer
import com.example.f1.core.data.result.F1Result
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseUseCaseRxJava<T: Any, in Params> {

    abstract fun execute(params: Params? = null): Single<T>

    operator fun invoke(
        params: Params? = null,
        onResult: (F1Result<T>) -> Unit,
        onDisposable: (Disposable) -> Unit
    ) {
        execute(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                F1Observer(onResult) { disposable -> onDisposable(disposable) }
            )
    }

}