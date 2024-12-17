package com.oilpay.mobile.presentation.ui.main.main.component.navigation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent

internal interface MainRootComponent {
    val childStack: Value<ChildStack<*, DecomposeComponent>>
}