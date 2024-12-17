package com.oilpay.mobile.data.local.api

interface AuthStorage {
    suspend fun setAccessToken(token: String)
    suspend fun setRefreshToken(token: String)
    suspend fun getAccessToken(): String
    suspend fun getRefreshToken(): String
}