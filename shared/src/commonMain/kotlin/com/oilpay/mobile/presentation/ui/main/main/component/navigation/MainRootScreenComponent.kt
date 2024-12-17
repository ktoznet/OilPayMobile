package com.oilpay.mobile.presentation.ui.main.main.component.navigation

import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.core.content.ComponentContentOwner
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.events.EventsProducer

interface MainRootScreenComponent :
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<MainRootScreenComponent.Event> {

    fun interface Factory {
        fun create(
            context: AppComponentContext,
        ): MainRootScreenComponent
    }

    sealed class Event {

    }
}