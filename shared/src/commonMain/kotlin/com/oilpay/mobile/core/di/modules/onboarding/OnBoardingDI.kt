package com.oilpay.mobile.core.di.modules.onboarding

import com.oilpay.mobile.domain.useCase.onBoarding.SetViewedOnBoardingUseCase
import com.oilpay.mobile.presentation.ui.onBoarding.component.OnBoardingComponent
import com.oilpay.mobile.presentation.ui.onBoarding.component.DefaultOnBoardingComponent
import com.oilpay.mobile.presentation.ui.onBoarding.component.OnBoardingInteractor
import com.oilpay.mobile.presentation.ui.onBoarding.component.OnBoardingInteractorImpl
import org.koin.dsl.module

val onBoardingModuleDI = module {
    single {
        OnBoardingComponent.Factory { context ->
            DefaultOnBoardingComponent(context)
        }
    }
}

val onBoardingModule = module {
    factory { SetViewedOnBoardingUseCase(get()) }
    factory<OnBoardingInteractor> { OnBoardingInteractorImpl() }
}