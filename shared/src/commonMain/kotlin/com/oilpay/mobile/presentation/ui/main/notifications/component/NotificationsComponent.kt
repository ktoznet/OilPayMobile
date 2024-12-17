import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.presentation.ui.main.notifications.NotificationElement

interface NotificationsComponent: DecomposeComponent {
    val notifications: List<NotificationElement>

    fun onBack()

    fun interface Factory {
        fun create(context: AppComponentContext,onBack: () -> Unit): NotificationsComponent
    }
}
