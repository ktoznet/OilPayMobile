package com.oilpay.mobile.presentation.ui.splash.component

import com.oilpay.mobile.presentation.mvi.MviStore

data class SplashState(
    val isLoading: Boolean = false
)

sealed interface SplashAction {

}

sealed interface OnBoardingSideEffect {

}

class SplashStore: MviStore<SplashState, SplashAction, OnBoardingSideEffect>(
    state = SplashState()
),  SplashInteractor by SplashInteractorImpl()