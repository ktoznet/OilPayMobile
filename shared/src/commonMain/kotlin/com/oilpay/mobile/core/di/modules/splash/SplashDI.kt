package com.oilpay.mobile.core.di.modules.splash

import com.oilpay.mobile.domain.useCase.auth.IsUserAuthenticatedUseCase
import com.oilpay.mobile.domain.useCase.onBoarding.GetOnBoardingViewedUseCase
import com.oilpay.mobile.presentation.ui.splash.component.DefaultSplashComponent
import com.oilpay.mobile.presentation.ui.splash.component.SplashComponent
import com.oilpay.mobile.presentation.ui.splash.component.SplashInteractor
import com.oilpay.mobile.presentation.ui.splash.component.SplashInteractorImpl
import org.koin.dsl.module

val splashModuleDI = module {
    single {
        SplashComponent.Factory { context ->
            DefaultSplashComponent(context)
        }
    }
}

val splashModule = module {
    factory { GetOnBoardingViewedUseCase(get()) }
    factory { IsUserAuthenticatedUseCase(get()) }
    factory<SplashInteractor> { SplashInteractorImpl() }
}