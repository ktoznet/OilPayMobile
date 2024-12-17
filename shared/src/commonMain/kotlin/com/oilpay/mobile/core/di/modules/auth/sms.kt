package com.oilpay.mobile.core.di.modules.auth


import com.oilpay.mobile.core.ext.createHttpClient
import com.oilpay.mobile.data.remote.api.auth.AuthApi
import com.oilpay.mobile.data.remote.api.auth.DefaultAuthApi
import com.oilpay.mobile.data.repository.DefaultAuthRepository
import com.oilpay.mobile.domain.repository.auth.AuthRepository
import com.oilpay.mobile.domain.useCase.auth.ConfirmCodeUseCase
import com.oilpay.mobile.domain.useCase.auth.RefreshTokenUseCase
import com.oilpay.mobile.domain.useCase.auth.SendSmsCodeUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val smsModule = module {
    single { createHttpClient() }

    singleOf(::DefaultAuthRepository) { bind<AuthRepository>() }
    singleOf(::DefaultAuthApi) { bind<AuthApi>() }

    factoryOf(::SendSmsCodeUseCase)
    factory { ConfirmCodeUseCase(get()) }
    factory { RefreshTokenUseCase(get()) }
}
