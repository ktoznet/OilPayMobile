package com.oilpay.mobile.presentation.ui.main.main.component

import MainScreenComponent
import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.value.MutableValue
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.ui.main.main.Card
import com.oilpay.mobile.presentation.ui.main.main.MainScreen

class DefaultMainScreenComponent(
    componentContext: AppComponentContext,
    private val onNavigateToAddCard: () -> Unit,
    private val onNavigateToCardDetail: (Card) -> Unit,
    private val onNavigateToAntiRadar: () -> Unit,
    private val onNavigateToHistory: () -> Unit,
    private val onNavigateToNotifications: () -> Unit,
    private val onNavigateToAutoShop: () -> Unit
) : MainScreenComponent, AppComponentContext by componentContext {

    override val content: ComponentContent = MainScreen(this)
    private val _searchQuery = MutableValue("")
    override val searchQuery: String get() = _searchQuery.value
    private val _showBottomSheet = mutableStateOf<BottomSheetType>(BottomSheetType.None)
    override val showBottomSheet: BottomSheetType get() = _showBottomSheet.value



    override val card: Card? = null
    override val categories: List<String> = listOf(
        "Заправка",
        "Авто-магазин",
        "Мое авто",
        "Акции"
    )
    override fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    override fun onCategoryClick(category: String) {
         when (category) {
            "Заправка" -> navigateToMap()
            "Авто-магазин" -> navigateToShop()
            "Мое авто" -> navigateToMyCar()
            "Акции" -> navigateToPromotions()
             else -> println("Неизвестная категория: $category")
         }
    }

    override fun onAddCard() {
        onNavigateToAddCard()
    }

    override fun onCardDetail(card: Card) {
        onNavigateToCardDetail(card)
    }

    override fun onAntiRadar() {
        onNavigateToAntiRadar()
    }

    override fun onHistory() {
        onNavigateToHistory()
    }

    override fun onNotifications() {
        onNavigateToNotifications()
    }
    private fun navigateToMap() {
        println("Переход на экран Заправка")
    }
    private fun navigateToShop() {
        println("Переход на экран navigateToShop")
        onNavigateToAutoShop()
    }
    private fun navigateToMyCar() {
        openBottomSheet(BottomSheetType.MyCar)
    }
    private fun navigateToPromotions() {
        openBottomSheet(BottomSheetType.Promotions)
    }



    override fun openBottomSheet(type: BottomSheetType) {
        _showBottomSheet.value = type
    }

    override fun closeBottomSheet() {
        _showBottomSheet.value = BottomSheetType.None
    }

    sealed class BottomSheetType {
        data object MyCar : BottomSheetType()
        data object Promotions : BottomSheetType()
        data object None : BottomSheetType()
        data object AddCard : BottomSheetType()
    }
}
