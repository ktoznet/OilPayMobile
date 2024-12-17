package com.oilpay.mobile.presentation.ui.smscode

import androidx.lifecycle.ViewModel
import com.oilpay.mobile.presentation.components.input.textfield.CodeStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.oilpay.mobile.presentation.ui.smscode.SmsCodeState

class SmsCodeVM : ViewModel() {
    private val _state = MutableStateFlow(SmsCodeState())
    val state = _state.asStateFlow()

    fun onSmsValueChange(value: String) {
        _state.update {
            it.copy(
                smsValue = value
            )
        }
    }


    // TODO: Fix CountDown Timer
//    val tt = viewModelScope.launch {
//        delay(1000)
//        _state.update {
//            it.copy(time = state.values.time - 1)
//        }
//        if (state.values.time <= 0) {
//            _state.update {
//                it.copy(isTimeEnd = true)
//            }
//        }
//    }

    fun updateStatus(status: CodeStatus) {
        if (status == CodeStatus.Correct) _state.update {
            it.copy(
                isCorrect = true,
                codeStatus = status
            )
        } else _state.update { it.copy(isCorrect = false, codeStatus = status) }
    }

}