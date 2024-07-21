package com.example.f1.core.data.response

data class BaseResponse<T>(
    val results: Int,
    val response: List<T>
)
