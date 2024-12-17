package com.oilpay.mobile.presentation.ui.identity.component.auth

import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.core.content.ComponentContentOwner
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.events.EventsProducer

interface AuthRootScreenComponent :
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<AuthRootScreenComponent.Event> {

    fun interface Factory {

        fun create(
            context: AppComponentContext,
        ): AuthRootScreenComponent
    }

    sealed class Event {

        data object OnBackClick : Event()
    }
}