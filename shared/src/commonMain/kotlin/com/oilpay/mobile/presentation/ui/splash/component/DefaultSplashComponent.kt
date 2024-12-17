package com.oilpay.mobile.presentation.ui.splash.component

import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.oilpay.mobile.presentation.ui.splash.ui.SplashScreen
import kotlinx.coroutines.delay
import com.oilpay.mobile.presentation.mvi.MviComponent
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.events.EventsProducerDelegate
import com.oilpay.mobile.core.events.EventsProducerDelegateImpl

internal class DefaultSplashComponent(
    private val appComponentContext: AppComponentContext,
):  SplashComponent,
    MviComponent<SplashState, SplashAction, OnBoardingSideEffect, SplashStore>,
    AppComponentContext by appComponentContext,
    EventsProducerDelegate<SplashComponent.Event> by EventsProducerDelegateImpl() {

    override val content: ComponentContent = SplashScreen(this)
    override val store: SplashStore = instanceKeeper.getOrCreate { SplashStore() }

    init {
        checkNavigation()
    }

    override fun dispatchAction(action: SplashAction) {

    }

    private fun checkNavigation() = store.launch {
        val isAuth = store.isAuthUser()
        val isViewOnBoarding = store.onBoardingInfoViewed()

        println("Status boarding: $isViewOnBoarding")
        println("Status auth: $isAuth")
        delay(2000)

        when {
            !isAuth && isViewOnBoarding -> dispatch(SplashComponent.Event.NavigateToAuth)
        }

    }
}