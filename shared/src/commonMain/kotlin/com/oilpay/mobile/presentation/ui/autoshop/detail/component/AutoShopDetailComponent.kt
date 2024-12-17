import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.presentation.ui.autoshop.detail.AutoShopManufacturerDetail

interface AutoShopDetailComponent: DecomposeComponent {
    val manufacturerDetails: List<AutoShopManufacturerDetail>
    fun onShowOnMapClick()

    fun interface Factory {
        fun create(context: AppComponentContext, id: Int): AutoShopDetailComponent
    }
}
