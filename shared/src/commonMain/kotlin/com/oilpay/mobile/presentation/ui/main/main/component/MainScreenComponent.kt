import com.oilpay.mobile.core.content.ComponentContentOwner
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.presentation.ui.main.main.Card
import com.oilpay.mobile.presentation.ui.main.main.component.DefaultMainScreenComponent
import com.oilpay.mobile.presentation.ui.main.main.component.DefaultMainScreenComponent.BottomSheetType

interface MainScreenComponent: DecomposeComponent, ComponentContentOwner{
    val card: Card?
    val categories: List<String>
    val searchQuery: String
    val showBottomSheet: DefaultMainScreenComponent.BottomSheetType

    fun onSearchQueryChange(query: String)
    fun onCategoryClick(category: String)
    fun onAddCard()
    fun onCardDetail(card: Card)
    fun onAntiRadar()
    fun onHistory()
    fun onNotifications()
    fun closeBottomSheet()

    fun interface Factory {
        fun create(context: AppComponentContext): MainScreenComponent
    }

    sealed class Event {

        data object NavigateTo : Event()
    }
     fun openBottomSheet(type: BottomSheetType)

}
