package com.oilpay.mobile.presentation.ui.verification.component.otp

import com.oilpay.mobile.presentation.mvi.MviStore

data class OtpCodeState(
    val isLoading: Boolean = false,
    val otp: String = "",
    val phone: String = "",
    val timer: Int = 60,
    val isTimerEnd: Boolean = false
)

sealed interface OtpCodeAction {
    data object ClickConfirm: OtpCodeAction
    data class InputCode(val otp: String): OtpCodeAction
    data object ResendCode: OtpCodeAction
    data object CallOperator: OtpCodeAction
}

sealed interface OtpCodeSideEffect {

}

class OtpCodeStore: MviStore<OtpCodeState, OtpCodeAction, OtpCodeSideEffect>(
    state = OtpCodeState()
),  OtpCodeInteractor by OtpCodeInteractorImpl()