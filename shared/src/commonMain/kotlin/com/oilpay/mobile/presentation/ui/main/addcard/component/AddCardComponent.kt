import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent

interface AddCardComponent: DecomposeComponent {
    fun onAddOilPayCard()
    fun onAddSumCard()
    fun onOrderCard()

    fun interface Factory {
        fun create(
            context: AppComponentContext,
            onNavigateToAddSumCard: () -> Unit,
            onNavigateToOrderCard: () -> Unit
        ): AddCardComponent
    }
}
