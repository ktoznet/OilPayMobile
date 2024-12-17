import com.oilpay.mobile.core.context.AppComponentContext

class DefaultAddCardComponent(
    componentContext: AppComponentContext,
    private val onNavigateToAddSumCard: () -> Unit,
    private val onNavigateToOrderCard: () -> Unit
) : AddCardComponent, AppComponentContext by componentContext {

    override fun onAddOilPayCard() {
        onNavigateToAddSumCard()
    }

    override fun onAddSumCard() {
        onNavigateToAddSumCard()
    }

    override fun onOrderCard() {
        onNavigateToOrderCard()
    }
}
