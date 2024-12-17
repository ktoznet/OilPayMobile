package com.oilpay.mobile.presentation.ui.identity.component.login

import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.core.content.ComponentContentOwner
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.events.EventsProducer

interface LoginComponent :
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<LoginComponent.Event> {

    fun interface Factory {

        fun create(context: AppComponentContext): LoginComponent
    }

    sealed class Event {

        data class NavigateToOtp(val phone: String) : Event()
        data class ShowError(val message: String) : Event() // Добавлено событие
    }
}