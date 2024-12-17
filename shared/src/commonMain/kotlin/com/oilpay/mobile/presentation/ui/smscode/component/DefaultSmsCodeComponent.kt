import com.arkivanov.decompose.value.MutableValue
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.input.textfield.CodeStatus
import com.oilpay.mobile.presentation.ui.smscode.SmsCodeState

class DefaultSmsCodeComponent(
    componentContext: AppComponentContext,
    private val number: String,
    private val onConfirmAction: () -> Unit
) : SmsCodeComponent, AppComponentContext by componentContext {

    private val _state = MutableValue(SmsCodeState())
    override val state: SmsCodeState get() = _state.value

    override fun onSmsValueChange(value: String) {
        _state.value = _state.value.copy(
            smsValue = value,
            codeStatus = when (value) {
                "11111" -> CodeStatus.Correct
                "99999" -> CodeStatus.Error
                else -> CodeStatus.Default
            },
            isCorrect = value == "11111"
        )
    }

    override fun onResendCode() {
        _state.value = _state.value.copy(
            time = 60,
            isTimeEnd = false,
            smsValue = "",
            codeStatus = CodeStatus.Default
        )
    }

    override fun onContactOperator() {
        // Логика контакта с оператором
    }

    override fun onConfirm() {
        if (_state.value.isCorrect) {
            onConfirmAction()
        }
    }
}
