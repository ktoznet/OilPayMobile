package com.oilpay.mobile.domain.useCase.auth

import com.oilpay.mobile.core.utils.Either
import com.oilpay.mobile.core.utils.Failure
import com.oilpay.mobile.domain.entities.auth.ApiResponse
import com.oilpay.mobile.domain.entities.auth.ApiResult
import com.oilpay.mobile.domain.entities.base.BaseEntityUIResponse
import com.oilpay.mobile.domain.repository.auth.AuthRepository
import com.oilpay.mobile.domain.useCase.base.BaseUseCase


class SendSmsCodeUseCase(private val repository: AuthRepository): BaseUseCase<SendSmsCodeUseCase.Params, BaseEntityUIResponse>() {
    class Params(val phone: String)

    override suspend fun execute(params: Params): Either<Failure, BaseEntityUIResponse> {
        return repository.sendSmsCode(params.phone)
    }
}
