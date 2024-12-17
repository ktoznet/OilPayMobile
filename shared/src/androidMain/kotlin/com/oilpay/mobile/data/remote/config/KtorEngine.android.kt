package com.oilpay.mobile.data.remote.config

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.okhttp.OkHttp


actual val ktorEngine: HttpClientEngineFactory<*> = OkHttp