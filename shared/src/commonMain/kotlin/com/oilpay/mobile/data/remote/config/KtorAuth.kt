package com.oilpay.mobile.data.remote.config

import com.oilpay.mobile.core.di.setup.Injector
import com.oilpay.mobile.data.local.api.AuthStorage
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer


fun HttpClientConfig<*>.installAuth() {
    val tokenStorage by Injector.lazy<AuthStorage>()

    install(Auth) {
        bearer {
            loadTokens {
                val accessToken = tokenStorage.getAccessToken()
                val refreshToken = tokenStorage.getRefreshToken()

                if (accessToken.isNotEmpty() && refreshToken.isNotEmpty()) {
                    BearerTokens(accessToken, refreshToken)
                } else {
                    null
                }
            }
            refreshTokens {
                val newAccessToken = tokenStorage.getAccessToken()
                val newRefreshToken = tokenStorage.getRefreshToken()

                if (newAccessToken.isNotEmpty() && newRefreshToken.isNotEmpty()) {
                    BearerTokens(newAccessToken, newRefreshToken)
                } else {
                    null
                }
            }
        }
    }
}