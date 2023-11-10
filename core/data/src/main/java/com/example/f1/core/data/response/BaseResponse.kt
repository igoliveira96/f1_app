package com.example.f1.core.data.response

sealed class BaseResponse<T>(
    val result: Int,
    val response: List<T>
)
