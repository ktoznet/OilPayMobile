package com.oilpay.mobile.presentation.ui.splash.component

import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.core.content.ComponentContentOwner
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.events.EventsProducer

interface SplashComponent:
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<SplashComponent.Event> {

    fun interface Factory {
        fun create(context: AppComponentContext): SplashComponent
    }

    sealed class Event {
        data object NavigateToAuth: Event()
    }
}