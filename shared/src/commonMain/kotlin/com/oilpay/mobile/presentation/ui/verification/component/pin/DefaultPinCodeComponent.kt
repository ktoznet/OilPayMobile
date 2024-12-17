package com.oilpay.mobile.presentation.ui.verification.component.pin

import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.oilpay.mobile.presentation.ui.verification.ui.pin.PinCodeScreen
import com.oilpay.mobile.presentation.mvi.MviComponent
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.events.EventsProducerDelegate
import com.oilpay.mobile.core.events.EventsProducerDelegateImpl
import com.oilpay.mobile.presentation.ui.verification.ui.pin.PincodeRepeatScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DefaultPinCodeComponent(
    appComponentContext: AppComponentContext,
    private val isRepeat: Boolean,
    private val onPinConfirmed: (String) -> Unit,
    private val onNavigateToBiometry: () -> Unit
):
    PinCodeComponent,
    AppComponentContext by appComponentContext,
    MviComponent<PinCodeState, PinCodeAction, PinCodeSideEffect, PinCodeStore>,
    EventsProducerDelegate<PinCodeComponent.Event> by EventsProducerDelegateImpl()
{

    private val _pin = MutableStateFlow("")
    override val pin: StateFlow<String> get() = _pin

    override fun onDigitClick(digit: String) {
        if (_pin.value.length < 4) {
            _pin.value += digit
        }
    }

    override fun onDeleteClick() {
        if (_pin.value.isNotEmpty()) {
            _pin.value = _pin.value.dropLast(1)
        }
    }

    override fun onConfirm() {
        if (isRepeat) {
            onNavigateToBiometry()
        } else {
            onPinConfirmed(_pin.value)
        }
    }
    override val content: ComponentContent
    get() = if(isRepeat){
        PincodeRepeatScreen(this)
    }else{
        PinCodeScreen(this)
    }


    override val store: PinCodeStore = instanceKeeper.getOrCreate { PinCodeStore() }

    override fun dispatchAction(action: PinCodeAction) {

    }
}