package com.oilpay.mobile.domain.useCase.auth

import com.oilpay.mobile.data.local.api.AuthStorage

class IsUserAuthenticatedUseCase(
    private val authStorage: AuthStorage
) {
    suspend operator fun invoke(): Boolean {
        return authStorage.getAccessToken().isNotEmpty()
    }
}
