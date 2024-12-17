package com.oilpay.mobile.data.repository

import com.oilpay.mobile.core.utils.Either
import com.oilpay.mobile.core.utils.Failure
import com.oilpay.mobile.core.utils.apiCall
import com.oilpay.mobile.data.entity.auth.AuthEntityRequest
import com.oilpay.mobile.data.mappers.toUI
import com.oilpay.mobile.data.remote.api.auth.AuthApi
import com.oilpay.mobile.domain.entities.auth.ApiResult
import com.oilpay.mobile.domain.entities.auth.ConfirmCodeRequest
import com.oilpay.mobile.domain.entities.auth.TokenResponse
import com.oilpay.mobile.domain.entities.base.BaseEntityUIResponse
import com.oilpay.mobile.domain.repository.auth.AuthRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.plugins.*

class DefaultAuthRepository(
    private val authApi: AuthApi,
    private val client: HttpClient
) : AuthRepository {
    private val baseUrl = "http://89.111.154.185:8000/api/v1/auth"

    override suspend fun sendSmsCode(phone: String): Either<Failure, BaseEntityUIResponse> {
        return apiCall(
            call = { authApi.sendAuthCode(AuthEntityRequest(phone = phone)) },
            mapResponse = { it.toUI() }
        )
    }

    override suspend fun confirmCode(phone: String, code: Int): ApiResult<TokenResponse> {
        return try {
            val response = client.post("$baseUrl/confirm") {
                setBody(ConfirmCodeRequest(phone = phone, code = code))
            }.body<TokenResponse>()
            ApiResult.Success(response)
        }catch (e: ClientRequestException) {
            val errorBody = e.response.status.description
            println("Client error: $errorBody")
            ApiResult.Error(Exception("Client error: $errorBody"))
        } catch (e: ServerResponseException) {
            println("Server error: ${e.response.status.description}")
            ApiResult.Error(Exception("Server error"))
        }  catch (e: Throwable) {
            handleException(e)
        }
    }

    override suspend fun refreshToken(refreshToken: String): ApiResult<TokenResponse> {
        return try {
            val response = client.post("$baseUrl/refresh") {
                setBody(mapOf("refresh_token" to refreshToken))
            }.body<TokenResponse>()
            ApiResult.Success(response)
        } catch (e: Throwable) {
            handleException(e)
        }
    }

    private fun <T> handleException(exception: Throwable): ApiResult<T> {
        return when (exception) {
            is ClientRequestException -> ApiResult.Error(
                Exception("Client error: ${exception.response.status.description}")
            )
            is ServerResponseException -> ApiResult.Error(
                Exception("Server error: ${exception.response.status.description}")
            )
            is ResponseException -> ApiResult.Error(
                Exception("HTTP error: ${exception.response.status.description}")
            )
            else -> ApiResult.Error(
                Exception("Unexpected error: ${exception.message}")
            )
        }
    }
}
