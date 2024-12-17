import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.presentation.ui.main.main.Card

interface CardDetailComponent: DecomposeComponent {
    val card: Card
    val isMainCard: Boolean
    val isMonitoringEnabled: Boolean

    fun onSetMainCard(checked: Boolean)
    fun onToggleMonitoring(checked: Boolean)
    fun onDeleteCard()

    fun interface Factory {
        fun create(context: AppComponentContext, card: Card,  onDelete: () -> Unit
        ): CardDetailComponent
    }
}
