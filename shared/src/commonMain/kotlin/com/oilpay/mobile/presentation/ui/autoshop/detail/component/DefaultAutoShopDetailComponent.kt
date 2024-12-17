import com.arkivanov.decompose.value.MutableValue
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.ui.autoshop.detail.AutoShopManufacturerDetail

class DefaultAutoShopDetailComponent(
    componentContext: AppComponentContext,
    private val id: Int,
    private val onMapClick: (Int) -> Unit
) : AutoShopDetailComponent, AppComponentContext by componentContext {
    val title = "Lorem ipsum dolor sit amet, consectetur"


    private val _manufacturerDetails = MutableValue(
        listOf(
            AutoShopManufacturerDetail(0, "", title, price = "3 000 000"),
            AutoShopManufacturerDetail(1, "", title, "0 000 000", price = "3 000 000"),
            AutoShopManufacturerDetail(2, "", title, price = "3 000 000"),
            AutoShopManufacturerDetail(3, "", title, price = "3 000 000"),
            AutoShopManufacturerDetail(4, "", title, price = "3 000 000"),
        )
    )

    override val manufacturerDetails: List<AutoShopManufacturerDetail>
        get() = _manufacturerDetails.value

    override fun onShowOnMapClick() {
        onMapClick(id)
    }
}

