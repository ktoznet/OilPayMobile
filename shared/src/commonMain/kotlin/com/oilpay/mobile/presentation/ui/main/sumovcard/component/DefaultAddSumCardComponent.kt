import com.arkivanov.decompose.value.MutableValue
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.ui.main.main.Card
import com.oilpay.mobile.presentation.ui.main.main.CardBankInfo
import com.oilpay.mobile.presentation.ui.main.main.CardPaymentSystem

class DefaultAddSumCardComponent(
    componentContext: AppComponentContext,
    private val onCardAdded: (Card) -> Unit
) : AddSumCardComponent, AppComponentContext by componentContext {

    private val _cardNumber = MutableValue("")
    private val _cardDate = MutableValue("")
    private val _isMainCard = MutableValue(false)

    override val cardNumber: String get() = _cardNumber.value
    override val cardDate: String get() = _cardDate.value
    override val isMainCard: Boolean get() = _isMainCard.value

    override fun onCardNumberChange(value: String) {
        _cardNumber.value = value
    }

    override fun onCardDateChange(value: String) {
        _cardDate.value = value
    }

    override fun onSetMainCard(checked: Boolean) {
        _isMainCard.value = checked
    }

    override fun onAddCard() {
        val examplePaymentSystem = CardPaymentSystem(
            id = 1,
            icon = "",
            name = "HUMO"
        )
        val exampleCardBankInfo = CardBankInfo(
            id = 1,
            icon = "",
            name = "KAPITAL BANK"
        )
        val newCard = Card(
            id = 1,
            cardNumber = cardNumber,
            paymentSystem = examplePaymentSystem,
            bankInfo = exampleCardBankInfo,
            balance = "0",
        )
        onCardAdded(newCard)
    }
}
