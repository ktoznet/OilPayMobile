package com.oilpay.mobile.data.local.datasource

import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

private val ACCESS_TOKEN = stringPreferencesKey("access_token")
private val REFRESH_TOKEN = stringPreferencesKey("refresh_token")
private val ON_BOARDING = booleanPreferencesKey("on_boarding")


internal fun MutablePreferences.accessToken(accessToken: String) {
    this[ACCESS_TOKEN] = accessToken
}

internal fun MutablePreferences.refreshToken(refreshToken: String) {
    this[REFRESH_TOKEN] = refreshToken
}

internal fun MutablePreferences.onBoardingViewed(status: Boolean) {
    this[ON_BOARDING] = status
}


internal val Preferences.accessToken: String
    get() = this[ACCESS_TOKEN] ?: ""

internal val Preferences.refreshToken: String
    get() = this[REFRESH_TOKEN] ?: ""


internal val Preferences.onBoarding: Boolean
    get() = this[ON_BOARDING] ?: false