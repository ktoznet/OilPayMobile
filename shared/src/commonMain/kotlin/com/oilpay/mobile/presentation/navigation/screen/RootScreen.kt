package com.oilpay.mobile.presentation.navigation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.oilpay.mobile.presentation.navigation.components.RootComponent
import com.oilpay.mobile.core.content.ComponentContentOwner

@Composable
fun RootScreen(component: RootComponent) {
    Children(
        stack = component.childStack,
        animation = stackAnimation { child ->
            when(child.instance) {
                else -> fade() + scale()
            }
        }
    ) { stack ->
        when(val instance = stack.instance) {
            is ComponentContentOwner -> instance.content.Content(Modifier)
        }
    }
}