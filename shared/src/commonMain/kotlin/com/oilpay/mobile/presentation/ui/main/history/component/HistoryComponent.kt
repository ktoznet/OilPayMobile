import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.presentation.ui.main.history.HistoryElement

interface HistoryComponent: DecomposeComponent {
    val historyItems: List<HistoryElement>

    fun onBack()

    fun interface Factory {
        fun create(context: AppComponentContext, onBack: () -> Unit): HistoryComponent
    }
}
