package com.oilpay.mobile.presentation.ui.splash.component


import com.oilpay.mobile.domain.useCase.auth.IsUserAuthenticatedUseCase
import com.oilpay.mobile.domain.useCase.onBoarding.GetOnBoardingViewedUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface SplashInteractor {
    suspend fun onBoardingInfoViewed(): Boolean
    suspend fun isAuthUser(): Boolean
}

internal class SplashInteractorImpl: SplashInteractor, KoinComponent {

    private val getOnBoardingViewedUseCase: GetOnBoardingViewedUseCase by inject()
    private val isUserAuthenticatedUseCase: IsUserAuthenticatedUseCase by inject()
    override suspend fun onBoardingInfoViewed(): Boolean {
        return getOnBoardingViewedUseCase()
    }

    override suspend fun isAuthUser(): Boolean {
        return isUserAuthenticatedUseCase()
    }

}