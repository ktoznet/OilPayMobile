package com.oilpay.mobile.presentation.ui.identity.component.login

import com.oilpay.mobile.core.utils.Either
import com.oilpay.mobile.core.utils.Failure
import com.oilpay.mobile.domain.entities.base.BaseEntityUIResponse
import com.oilpay.mobile.domain.useCase.auth.SendSmsCodeUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface LoginInteractor {
    suspend fun sendAuthCode(phone: String): Either<Failure, BaseEntityUIResponse>
}

class LoginInteractorImpl: LoginInteractor, KoinComponent {
    private val sendSmsCodeUseCase: SendSmsCodeUseCase by inject()

    override suspend fun sendAuthCode(phone: String): Either<Failure, BaseEntityUIResponse> {
        return sendSmsCodeUseCase.invoke(SendSmsCodeUseCase.Params(phone = phone))
    }
}