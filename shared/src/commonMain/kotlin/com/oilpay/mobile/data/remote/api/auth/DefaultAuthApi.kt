package com.oilpay.mobile.data.remote.api.auth

import com.oilpay.mobile.data.entity.auth.AuthEntityRequest
import com.oilpay.mobile.data.entity.base.BaseEntityResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

internal class DefaultAuthApi(
    private val httpClient: HttpClient
): AuthApi {
    override suspend fun sendAuthCode(body: AuthEntityRequest): BaseEntityResponse {
        return httpClient.post("/api/v1/auth") {
            setBody(body)
        }.body()
    }
}