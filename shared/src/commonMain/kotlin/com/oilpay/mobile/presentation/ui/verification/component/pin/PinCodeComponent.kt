package com.oilpay.mobile.presentation.ui.verification.component.pin

import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.core.content.ComponentContentOwner
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.events.EventsProducer
import kotlinx.coroutines.flow.StateFlow

interface PinCodeComponent:
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<PinCodeComponent.Event> {

    val pin: StateFlow<String>
    fun onDigitClick(digit: String)
    fun onDeleteClick()
    fun onConfirm()

    fun interface Factory {

        fun create(context: AppComponentContext,isRepeat: Boolean): PinCodeComponent
    }

    sealed class Event {
        data class NavigateToOtp(val phone: String) : Event()
    }
}