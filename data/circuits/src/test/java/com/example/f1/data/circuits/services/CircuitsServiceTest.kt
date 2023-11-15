package com.example.f1.data.circuits.services

import com.example.f1.data.circuits.data.remote.services.CircuitsService
import com.example.f1.data.circuits.utils.enqueueResponse
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CircuitsServiceTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var mockWebServer: MockWebServer
    private lateinit var circuitsService: CircuitsService

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        circuitsService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CircuitsService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `when server success expect a circuit list`() = runTest {
        mockWebServer.enqueueResponse("circuits.json", 200)

        val response = circuitsService.getCircuits()

        mockWebServer.takeRequest()

        assertThat(response.response).isNotEmpty()
    }

}