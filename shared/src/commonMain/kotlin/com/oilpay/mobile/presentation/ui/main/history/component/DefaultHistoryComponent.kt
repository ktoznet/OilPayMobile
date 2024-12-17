import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.ui.main.history.HistoryElement

class DefaultHistoryComponent(
    componentContext: AppComponentContext,
    private val onBack: () -> Unit
) : HistoryComponent, AppComponentContext by componentContext {

    override val historyItems = listOf(
        HistoryElement(
            gasName = "Uzbekneftegaz",
            id = "0000000000",
            location = "882V+556, Қорасув кўчаси, Тоshkent",
            date = "15.08.2024, 10:00",
            pump = 2,
            fuelType = "АИ-92",
            fuelAmount = 5,
            price = "52 500"
        ),
        HistoryElement(
            gasName = "Uzbekneftegaz",
            id = "0000000000",
            location = "882V+556, Қорасув кўчаси, Тоshkent",
            date = "15.08.2024, 10:00",
            pump = 2,
            fuelType = "АИ-92",
            fuelAmount = 5,
            price = "52 500"
        ),
        HistoryElement(
            gasName = "Uzbekneftegaz",
            id = "0000000000",
            location = "882V+556, Қорасув кўчаси, Тоshkent",
            date = "15.08.2024, 10:00",
            pump = 2,
            fuelType = "АИ-92",
            fuelAmount = 5,
            price = "52 500"
        ),
        HistoryElement(
            gasName = "Uzbekneftegaz",
            id = "0000000000",
            location = "882V+556, Қорасув кўчаси, Тоshkent",
            date = "15.08.2024, 10:00",
            pump = 2,
            fuelType = "АИ-92",
            fuelAmount = 5,
            price = "52 500"
        ),
        HistoryElement(
            gasName = "Uzbekneftegaz",
            id = "0000000000",
            location = "882V+556, Қорасув кўчаси, Тоshkent",
            date = "15.08.2024, 10:00",
            pump = 2,
            fuelType = "АИ-92",
            fuelAmount = 5,
            price = "52 500"
        ),
        HistoryElement(
            gasName = "Uzbekneftegaz",
            id = "0000000000",
            location = "882V+556, Қорасув кўчаси, Тоshkent",
            date = "15.08.2024, 10:00",
            pump = 2,
            fuelType = "АИ-92",
            fuelAmount = 5,
            price = "52 500"
        ),
    )

    override fun onBack() {
        onBack()
    }
}
