package com.oilpay.mobile.data.remote.config

import com.oilpay.mobile.core.utils.Failure
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode

fun HttpClientConfig<*>.installExceptionHandler() {
    HttpResponseValidator {
        handleResponseExceptionWithRequest { cause, request ->
            println(cause)
            println(request)
            throw Failure.Unknown
        }

        validateResponse { response ->
            val error = response.status != HttpStatusCode.OK
                        && response.status != HttpStatusCode.Created
                        && response.status != HttpStatusCode.NoContent
                        && response.status != HttpStatusCode.BadRequest
                        && response.status != HttpStatusCode.Forbidden
                        && response.status != HttpStatusCode.Accepted
            if (error) {
                val body = response.bodyAsText()


                throw Failure.Message("Попробуйте позже")
            }
        }
    }
}

private suspend fun tryCatch(body: suspend () -> Unit) {
    try {
        body()
    } catch (e: Exception) {
    }
}