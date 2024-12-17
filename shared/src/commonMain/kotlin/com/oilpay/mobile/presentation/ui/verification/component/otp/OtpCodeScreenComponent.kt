package com.oilpay.mobile.presentation.ui.verification.component.otp

import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.core.content.ComponentContentOwner
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.events.EventsProducer

interface OtpCodeScreenComponent:
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<OtpCodeScreenComponent.Event> {

    fun interface Factory {

        fun create(
            context: AppComponentContext,
            phone: String
        ): OtpCodeScreenComponent
    }

    sealed class Event {
        data class ShowMessage(val message: String) : Event()
        data class NavigateToNextScreen(val phone: String,val code: Int) : Event()
    }
}