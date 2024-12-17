package com.oilpay.mobile.presentation.ui.autoshop.categories.component


import com.oilpay.mobile.core.content.ComponentContentOwner
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.presentation.ui.autoshop.categories.AutoShopCategories

interface AutoShopCategoriesComponent:
    DecomposeComponent, ComponentContentOwner {
    val categories: List<AutoShopCategories>
    fun onCategorySelected(categoryId: Int)

    fun onBack()
    fun interface Factory {
        fun create(context: AppComponentContext): AutoShopCategoriesComponent
    }
    sealed class Event {

        data object NavigateTo : Event()
    }
}
