package com.oilpay.mobile.presentation.ui.identity.component.auth

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent

internal interface AuthRootComponent {
    val childStack: Value<ChildStack<*, DecomposeComponent>>
}