package com.oilpay.mobile.core.di.modules.network

import com.oilpay.mobile.data.remote.config.installAuth
import com.oilpay.mobile.data.remote.config.installDefaultRequest
import com.oilpay.mobile.data.remote.config.installExceptionHandler
import com.oilpay.mobile.data.remote.config.installJson
import com.oilpay.mobile.data.remote.config.installLogger
import com.oilpay.mobile.data.remote.config.installRetryConnection
import com.oilpay.mobile.data.remote.config.installTimeOut
import com.oilpay.mobile.data.remote.config.ktorEngine
import io.ktor.client.HttpClient

fun networkSetup(): HttpClient {
    return HttpClient(ktorEngine) {
        installAuth()
        installJson()
        installLogger()
        installTimeOut()
        installRetryConnection()
        installDefaultRequest()
        installExceptionHandler()
    }
}