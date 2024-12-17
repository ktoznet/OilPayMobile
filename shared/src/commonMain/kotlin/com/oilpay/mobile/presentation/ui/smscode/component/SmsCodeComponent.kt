import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.presentation.ui.smscode.SmsCodeState

interface SmsCodeComponent: DecomposeComponent{
    val state: SmsCodeState

    fun onSmsValueChange(value: String)
    fun onResendCode()
    fun onContactOperator()
    fun onConfirm()

    fun interface Factory {
        fun create(context: AppComponentContext, number: String, onConfirm: () -> Unit): SmsCodeComponent
    }
}
