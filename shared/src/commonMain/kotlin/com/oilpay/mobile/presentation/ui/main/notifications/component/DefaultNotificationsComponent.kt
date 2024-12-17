import com.arkivanov.decompose.ComponentContext
import com.oilpay.mobile.presentation.ui.main.notifications.NotificationElement
import com.oilpay.mobile.presentation.ui.main.notifications.NotificationType

class DefaultNotificationsComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit
) : NotificationsComponent, ComponentContext by componentContext {

    override val notifications = listOf(
        NotificationElement(0, "Срок страховки истек", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", "1 час назад",
            NotificationType.Insurance
        ),
        NotificationElement(1, "Срок страховки заканчивается", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", "05.07.2024",
            NotificationType.Insurance
        ),
        NotificationElement(2, "Внимание! Новый штраф на\n" +
                "100 000 сум", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", "05.07.2024",
            NotificationType.Fine
        ),
        NotificationElement(3, "Срок тонировки истек", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", "05.07.2024",
            NotificationType.Tinting
        ),
        NotificationElement(4, "Срок тонировки заканчивается", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", "05.07.2024",
            NotificationType.Tinting
        ),
        NotificationElement(5, "Внимание! Новый штраф на\n" +
                "200 000 сум", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", "05.07.2024",
            NotificationType.Important
        ),
    )

    override fun onBack() {
        onBack()
    }
}
