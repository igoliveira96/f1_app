package com.example.f1.core.data.mapper

abstract class BaseMapper<E, D> {

    abstract fun toDomain(data: E): D

    abstract fun fromDomain(domain: D): E

    fun toDomain(data: List<E>): List<D> = data.map {
        response -> toDomain(response)
    }

    fun fromDomain(data: List<D>): List<E> = data.map { domain ->
        fromDomain(domain)
    }

}