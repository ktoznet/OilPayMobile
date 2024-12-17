package com.oilpay.mobile.domain.useCase.auth

import com.oilpay.mobile.domain.entities.auth.ApiResult
import com.oilpay.mobile.domain.entities.auth.TokenResponse
import com.oilpay.mobile.domain.repository.auth.AuthRepository


class RefreshTokenUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(refreshToken: String): ApiResult<TokenResponse> {
        return repository.refreshToken(refreshToken)
    }
}
