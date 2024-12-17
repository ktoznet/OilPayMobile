package com.oilpay.mobile.presentation.ui.smscode

import com.oilpay.mobile.presentation.components.input.textfield.CodeStatus


data class SmsCodeState(
    val time: Int = 60,
    val codeStatus: CodeStatus = CodeStatus.Default,
    val smsValue: String = "",
    val isCorrect: Boolean = false,
    val isTimeEnd: Boolean = false,
)
