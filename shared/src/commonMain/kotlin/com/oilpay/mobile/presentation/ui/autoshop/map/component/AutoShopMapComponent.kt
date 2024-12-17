import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent

interface AutoShopMapComponent: DecomposeComponent {
    val id: Int
    fun onBack()

    fun interface Factory {
        fun create(context: AppComponentContext, id: Int): AutoShopMapComponent
    }
}
