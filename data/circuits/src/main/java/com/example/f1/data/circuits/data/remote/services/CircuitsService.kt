package com.example.f1.data.circuits.data.remote.services

import com.example.f1.core.data.response.BaseResponse
import com.example.f1.data.circuits.model.CircuitResponse
import retrofit2.http.GET

interface CircuitsService {

    @GET("circuits")
    suspend fun getCircuits(): BaseResponse<CircuitResponse>

}
