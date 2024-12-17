package com.oilpay.mobile.core.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext

fun interface ComponentContent {

    @Composable
    fun Content(
        modifier: Modifier,
    )
}