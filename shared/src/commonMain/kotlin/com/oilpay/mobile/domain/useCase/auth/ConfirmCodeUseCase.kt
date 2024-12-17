package com.oilpay.mobile.domain.useCase.auth

import com.oilpay.mobile.domain.entities.auth.ApiResult
import com.oilpay.mobile.domain.entities.auth.TokenResponse
import com.oilpay.mobile.domain.repository.auth.AuthRepository


class ConfirmCodeUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(phone: String, code: Int): ApiResult<TokenResponse> {
        return repository.confirmCode(phone, code)
    }
}
