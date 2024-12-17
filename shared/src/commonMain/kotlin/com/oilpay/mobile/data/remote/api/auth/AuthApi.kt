package com.oilpay.mobile.data.remote.api.auth

import com.oilpay.mobile.data.entity.auth.AuthEntityRequest
import com.oilpay.mobile.data.entity.base.BaseEntityResponse

interface AuthApi {
    suspend fun sendAuthCode(body: AuthEntityRequest): BaseEntityResponse
}