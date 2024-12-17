package com.oilpay.mobile.presentation.ui.verification.component.pin

import com.oilpay.mobile.presentation.ui.verification.models.PinCodeStep
import com.oilpay.mobile.presentation.mvi.MviStore

sealed interface PinCodeAction {
    data class InputPinCode(val pinCode: String): PinCodeAction
    data object ConfirmPinCode: PinCodeAction
    data object BackPinCode: PinCodeAction
}

sealed interface PinCodeSideEffect {

}

data class PinCodeState(
    val pinCode: String = "",
    val pinCodeFirst: String = "",
    val step: PinCodeStep = PinCodeStep.First
)

class PinCodeStore: MviStore<PinCodeState, PinCodeAction, PinCodeSideEffect>(
    state = PinCodeState()
),  PinCodeInteractor by PinCodeInteractorImpl()