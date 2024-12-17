package com.oilpay.mobile.data.local.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.oilpay.mobile.core.di.setup.Injector
import com.oilpay.mobile.data.local.api.AuthStorage
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

internal class AuthStorageImpl: AuthStorage {
    private val dataStore: DataStore<Preferences> by Injector.lazy()


    companion object {
        private val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
        private val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")
    }

    override suspend fun setAccessToken(token: String) {
        try {
                dataStore.edit { preferences ->
                    preferences[ACCESS_TOKEN_KEY] = token
                }
        } catch (e: Exception) {
            println("Failed to set access token: ${e.message}")
        }
    }

    override suspend fun setRefreshToken(token: String) {
        try {
                dataStore.edit { preferences ->
                    preferences[REFRESH_TOKEN_KEY] = token
                }
        } catch (e: Exception) {
            println("Failed to set refresh token: ${e.message}")
        }
    }

    override suspend fun getAccessToken(): String  {
        return try {
            dataStore.data.map { preferences ->
                preferences[ACCESS_TOKEN_KEY] ?: ""
            }.first()
        } catch (e: Exception) {
            println("Failed to get access token: ${e.message}")
            ""
        }
    }

    override suspend fun getRefreshToken(): String  {
        return try {
            dataStore.data.map { preferences ->
                preferences[REFRESH_TOKEN_KEY] ?: ""
            }.first()
        } catch (e: Exception) {
            println("Failed to get refresh token: ${e.message}")
            ""
        }
    }
}