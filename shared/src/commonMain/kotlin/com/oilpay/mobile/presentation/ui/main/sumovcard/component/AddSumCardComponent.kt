import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.presentation.ui.main.main.Card

interface AddSumCardComponent: DecomposeComponent {
    val cardNumber: String
    val cardDate: String
    val isMainCard: Boolean

    fun onCardNumberChange(value: String)
    fun onCardDateChange(value: String)
    fun onSetMainCard(checked: Boolean)
    fun onAddCard()

    fun interface Factory {
        fun create(context: AppComponentContext, onCardAdded: (Card) -> Unit): AddSumCardComponent
    }
}
