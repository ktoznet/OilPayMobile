package com.oilpay.mobile.presentation.ui.onBoarding.component

import com.oilpay.mobile.domain.useCase.onBoarding.SetViewedOnBoardingUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface OnBoardingInteractor {
    suspend fun setViewedOnBoarding(isViewed: Boolean = ON_BOARDING_VIEWED)

    companion object {
        private const val ON_BOARDING_VIEWED = true
    }
}

internal class OnBoardingInteractorImpl: OnBoardingInteractor, KoinComponent {
    private val setViewedOnBoardingUseCase: SetViewedOnBoardingUseCase by inject()

    override suspend fun setViewedOnBoarding(isViewed: Boolean) {
        setViewedOnBoardingUseCase(isViewed)
    }
}