package com.example.f1.core.data.mapper

abstract class BaseMapper<I, O> {

    abstract fun toDomain(data: I): O

    fun toDomain(data: List<I>): List<O> = data.map {
        response -> toDomain(response)
    }

}