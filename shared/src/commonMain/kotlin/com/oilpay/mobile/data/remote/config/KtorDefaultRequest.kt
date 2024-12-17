package com.oilpay.mobile.data.remote.config

import com.oilpay.mobile.core.utils.Constants
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpRedirect
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.ContentType

fun HttpClientConfig<*>.installDefaultRequest() {
    install(HttpRedirect) {
        checkHttpMethod = false
        allowHttpsDowngrade = false
    }

    defaultRequest {
        header("Content-Type", ContentType.Application.Json)
        url(Constants.BASE_URL)
    }
}