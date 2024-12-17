import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent

interface OrderCardComponent: DecomposeComponent {
    val surname: String
    val name: String
    val phone: String
    val isFormValid: Boolean

    fun onSurnameChange(value: String)
    fun onNameChange(value: String)
    fun onPhoneChange(value: String)
    fun onSubmit()

    fun interface Factory {
        fun create(context: AppComponentContext, onSmsScreen: (String) -> Unit): OrderCardComponent
    }
}
