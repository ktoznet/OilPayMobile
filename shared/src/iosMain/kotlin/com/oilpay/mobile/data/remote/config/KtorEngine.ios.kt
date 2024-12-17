package com.oilpay.mobile.data.remote.config

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin


actual val ktorEngine: HttpClientEngineFactory<*> = Darwin