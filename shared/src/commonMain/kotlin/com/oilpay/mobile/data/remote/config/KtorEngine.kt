package com.oilpay.mobile.data.remote.config

import io.ktor.client.engine.HttpClientEngineFactory

expect val ktorEngine: HttpClientEngineFactory<*>