package com.oilpay.mobile.domain.useCase.base

import com.oilpay.mobile.core.utils.Either
import com.oilpay.mobile.core.utils.Failure

/**
 * Базовый UseCase для бизнес логики
 */
abstract class BaseUseCase<in Params, out Type> where Type : Any {

    abstract suspend fun execute(params: Params): Either<Failure, Type>

    open suspend operator fun invoke(
        params: Params,
    ): Either<Failure, Type> {
        return try {
            execute(params)
        } catch (e: Exception) {
            Either.Left(Failure.Message(e.message.orEmpty()))
        }
    }
}