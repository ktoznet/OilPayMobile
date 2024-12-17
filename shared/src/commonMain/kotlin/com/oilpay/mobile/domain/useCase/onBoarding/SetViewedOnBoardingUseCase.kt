// domain/useCase/SetViewedOnBoardingUseCase.kt
package com.oilpay.mobile.domain.useCase.onBoarding

import com.oilpay.mobile.data.local.api.OnBoardingStorage

class SetViewedOnBoardingUseCase(
    private val onBoardingStorage: OnBoardingStorage
) {
    suspend operator fun invoke(isViewed: Boolean = true) {
        onBoardingStorage.setOnBoardingStatus(isViewed)
    }
}
