package com.example.f1.core.data.mock

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import javax.net.ssl.HttpsURLConnection

class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val responseBody = getMockedResponse(request)
        return chain.proceed(chain.request())
            .newBuilder()
            .protocol(Protocol.HTTP_2)
            .code(HttpsURLConnection.HTTP_OK)
            .message(responseBody)
            .body(
                responseBody.toByteArray().toResponseBody(
                    "application/json; charset=utf-8".toMediaType()
                )
            )
            .build()
    }

    private fun getMockedResponse(request: Request): String {
        return when (request.url.toString()) {
            "https://v1.formula-1.api-sports.io/circuits" -> getResponse("circuits.json")
            else -> ""
        }
    }

    private fun getResponse(fileName: String): String {
        val inputStream = javaClass.classLoader?.getResourceAsStream("api-response/$fileName")
        val bytes = inputStream?.readBytes()
        inputStream?.close()

        return if(bytes != null) String(bytes) else ""
    }


}