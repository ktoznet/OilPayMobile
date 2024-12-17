package com.oilpay.mobile.core.utils

import com.oilpay.mobile.core.utils.Either.*

inline fun <reified T : Any> apiCall(
    call: () -> T,
): Either<Failure, T> =
    try {
        Right(call.invoke())
    } catch (ex: Failure) {
        Left(ex)
    }


inline fun <reified T : Any?, reified R : Any> apiCall(
    call: () -> T,
    mapResponse: (T) -> R,
): Either<Failure, R> =
    try {
        Right(mapResponse(call.invoke()))
    } catch (ex: Failure) {
        Left(ex)
    }