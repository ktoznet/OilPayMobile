package com.oilpay.mobile.presentation.ui.onBoarding.component

import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.core.content.ComponentContentOwner
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.events.EventsProducer

interface OnBoardingComponent :
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<OnBoardingComponent.Event> {

    fun interface Factory {

        fun create(context: AppComponentContext): OnBoardingComponent
    }

    sealed class Event {
        data object NavigateToAuth: Event()
    }
}