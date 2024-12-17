package com.oilpay.mobile.domain.useCase.onBoarding

import com.oilpay.mobile.data.local.api.OnBoardingStorage

class GetOnBoardingViewedUseCase(
    private val onBoardingStorage: OnBoardingStorage
) {
    suspend operator fun invoke(): Boolean {
        return onBoardingStorage.onBoardingStatus()
    }
}
