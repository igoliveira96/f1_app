package com.example.f1.core.data.mapper

abstract class BaseMapperUI<D, U> {

    abstract fun toUI(data: D): U

    fun toUI(data: List<D>): List<U> = data.map {
        response -> toUI(response)
    }

}