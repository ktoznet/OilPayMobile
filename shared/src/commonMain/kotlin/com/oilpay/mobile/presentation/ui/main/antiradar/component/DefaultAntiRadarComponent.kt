import com.oilpay.mobile.core.context.AppComponentContext

class DefaultAntiRadarComponent(
    componentContext: AppComponentContext,
    private val onBack: () -> Unit
) : AntiRadarComponent, AppComponentContext by componentContext {

    override fun onBack() {
        onBack()
    }
}
