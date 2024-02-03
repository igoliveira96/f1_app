package com.example.f1.data.circuits.data.remote.services

import com.example.f1.core.data.response.BaseResponse
import com.example.f1.data.circuits.data.remote.response.CircuitResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CircuitsService {

    @GET("circuits")
    fun getCircuits(): Single<BaseResponse<CircuitResponse>>

}
