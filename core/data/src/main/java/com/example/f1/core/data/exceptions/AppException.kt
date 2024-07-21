package com.example.f1.core.data.exceptions

abstract class AppException(
    override val message: String,
    val code: Int? = null
): Exception()

class ParamsNotBeNullException: AppException("params not be null")