import com.oilpay.mobile.core.content.ComponentContentOwner
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent

interface ConfirmationComponent: DecomposeComponent, ComponentContentOwner{
    val passportValue: String
    val birthDateValue: String
    val showDatePicker: Boolean

    fun onPassportChange(value: String)
    fun onBirthDateChange(value: String)
    fun onCalendarClick()
    fun onDateSelected(millis: Long)
    fun onConfirm()
    fun onCancel()

    fun interface Factory {
        fun create(context: AppComponentContext): ConfirmationComponent
    }
}
