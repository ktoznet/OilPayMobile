package com.oilpay.mobile.presentation.navigation.components

import androidx.compose.runtime.Stable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent

fun buildRootComponent(
    componentContext: ComponentContext
): RootComponent = DefaultRootComponent(componentContext)

@Stable
interface RootComponent {
    val childStack: Value<ChildStack<*, DecomposeComponent>>
}