package com.oilpay.mobile.presentation.ui.autoshop.navigation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent

internal interface AutoShopRootComponent {
    val childStack: Value<ChildStack<*, DecomposeComponent>>
}