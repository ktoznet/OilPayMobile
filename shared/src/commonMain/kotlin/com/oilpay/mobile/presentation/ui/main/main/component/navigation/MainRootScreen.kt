package com.oilpay.mobile.presentation.ui.main.main.component.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.core.content.ComponentContentOwner


internal class MainRootScreen(
    private val component: MainRootComponent
): ComponentContent {
    @Composable
    override fun Content(modifier: Modifier) {
        Children(
            stack = component.childStack,
            animation = stackAnimation { child ->
                when(child.instance) {
                    else -> fade() + scale()
                }
            }
        ) { child ->
            when (val instance = child.instance) {
                is ComponentContentOwner -> instance.content.Content(modifier)
            }
        }
    }
}