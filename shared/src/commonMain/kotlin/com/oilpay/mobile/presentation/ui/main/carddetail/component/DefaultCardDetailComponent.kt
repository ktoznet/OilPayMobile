import com.arkivanov.decompose.value.MutableValue
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.ui.main.main.Card

class DefaultCardDetailComponent(
    componentContext: AppComponentContext,
    override val card: Card,
    private val onDelete: () -> Unit
) : CardDetailComponent, AppComponentContext by componentContext {

    private val _isMainCard = MutableValue(false)
    private val _isMonitoringEnabled = MutableValue(false)

    override val isMainCard: Boolean get() = _isMainCard.value
    override val isMonitoringEnabled: Boolean get() = _isMonitoringEnabled.value

    override fun onSetMainCard(checked: Boolean) {
        _isMainCard.value = checked
        // Дополнительная логика (например, обновление данных на сервере)
    }

    override fun onToggleMonitoring(checked: Boolean) {
        _isMonitoringEnabled.value = checked
        // Дополнительная логика
    }

    override fun onDeleteCard() {
        onDelete()
        // Дополнительная логика
    }
}
