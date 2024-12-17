import com.oilpay.mobile.core.context.AppComponentContext

class DefaultAutoShopMapComponent(
    componentContext: AppComponentContext,
    override val id: Int,
    private val onBackAction: () -> Unit
) : AutoShopMapComponent, AppComponentContext by componentContext {

    override fun onBack() {
        onBackAction()
    }
}
