package com.oilpay.mobile.presentation.ui.onBoarding.component

import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.oilpay.mobile.presentation.ui.onBoarding.ui.OnBoardingScreen
import com.oilpay.mobile.presentation.mvi.MviComponent
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.events.EventsProducerDelegate
import com.oilpay.mobile.core.events.EventsProducerDelegateImpl

internal class DefaultOnBoardingComponent(
    private val appComponentContext: AppComponentContext
):  OnBoardingComponent,
    MviComponent<OnBoardingState, OnBoardingAction, OnBoardingSideEffect, OnBoardingStore>,
    AppComponentContext by appComponentContext,
    EventsProducerDelegate<OnBoardingComponent.Event> by EventsProducerDelegateImpl() {

    override val content: ComponentContent = OnBoardingScreen(this)

    override val store: OnBoardingStore = instanceKeeper.getOrCreate { OnBoardingStore() }

    override fun dispatchAction(action: OnBoardingAction) {
        when(action) {
            OnBoardingAction.Skip -> skipOnBoarding()
            OnBoardingAction.NavigateToAuth -> dispatch(OnBoardingComponent.Event.NavigateToAuth)
            is OnBoardingAction.ChangePage -> intent { reduce { state.copy(page = action.page) } }
        }
    }

    private fun skipOnBoarding() {
        store.launch {
            store.setViewedOnBoarding()
        }
        dispatch(OnBoardingComponent.Event.NavigateToAuth)
    }

}