import com.arkivanov.decompose.value.MutableValue
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.ui.confirmation.ConfirmationScreen
import kotlinx.datetime.Instant
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents

class DefaultConfirmationComponent(
    componentContext: AppComponentContext,
    private val onConfirmed: () -> Unit,
    private val onNavigateToMain: () -> Unit
) : ConfirmationComponent, AppComponentContext by componentContext {


    override val content: ComponentContent = ConfirmationScreen(this)
    private val _passportValue = MutableValue("")
    private val _birthDateValue = MutableValue("")
    private val _showDatePicker = MutableValue(false)

    override val passportValue: String get() = _passportValue.value
    override val birthDateValue: String get() = _birthDateValue.value
    override val showDatePicker: Boolean get() = _showDatePicker.value

    override fun onPassportChange(value: String) {
        _passportValue.value = value.uppercase()
    }

    override fun onBirthDateChange(value: String) {
        _birthDateValue.value = value
    }

    override fun onCalendarClick() {
        _showDatePicker.value = true
    }

    override fun onDateSelected(millis: Long) {
        _birthDateValue.value = convertMillisToDate(millis)
        _showDatePicker.value = false
    }

    override fun onConfirm() {
        onConfirmed()
    }

    override fun onCancel() {
        onNavigateToMain()
    }

    private fun convertMillisToDate(millis: Long): String {
        val customFormat = DateTimeComponents.Format {
            dayOfMonth()
            monthNumber()
            year()
        }
        val currentTime = Instant.fromEpochMilliseconds(millis)
        return currentTime.format(customFormat)
    }

}
