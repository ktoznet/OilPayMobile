import com.arkivanov.decompose.value.MutableValue
import com.oilpay.mobile.core.context.AppComponentContext

class DefaultOrderCardComponent(
    componentContext: AppComponentContext,
    private val onSmsScreen: (String) -> Unit
) : OrderCardComponent, AppComponentContext by componentContext {

    private val _surname = MutableValue("")
    private val _name = MutableValue("")
    private val _phone = MutableValue("")

    override val surname: String get() = _surname.value
    override val name: String get() = _name.value
    override val phone: String get() = _phone.value
    override val isFormValid: Boolean
        get() = surname.isNotBlank() && name.isNotBlank() && phone.matches(Regex("\\+998 \\d{2} \\d{3} \\d{2} \\d{2}"))

    override fun onSurnameChange(value: String) {
        _surname.value = value
    }

    override fun onNameChange(value: String) {
        _name.value = value
    }

    override fun onPhoneChange(value: String) {
        _phone.value = value
    }

    override fun onSubmit() {
        if (isFormValid) {
            onSmsScreen(phone)
        }
    }
}
