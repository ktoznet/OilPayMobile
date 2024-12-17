package com.oilpay.mobile.domain.repository.auth

import com.oilpay.mobile.core.utils.Either
import com.oilpay.mobile.core.utils.Failure
import com.oilpay.mobile.domain.entities.auth.ApiResponse
import com.oilpay.mobile.domain.entities.auth.ApiResult
import com.oilpay.mobile.domain.entities.auth.TokenResponse
import com.oilpay.mobile.domain.entities.base.BaseEntityUIResponse

interface AuthRepository {
    suspend fun sendSmsCode(phone: String): Either<Failure, BaseEntityUIResponse>
    suspend fun confirmCode(phone: String, code: Int): ApiResult<TokenResponse>
    suspend fun refreshToken(refreshToken: String): ApiResult<TokenResponse>
}
