package com.oilpay.mobile.presentation.components.layout_helpers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
inline fun CenteredColumn(
    vertical: Arrangement.Vertical = Arrangement.Center,
    horizontal: Alignment.Horizontal = Alignment.Start,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        verticalArrangement = vertical,
        horizontalAlignment = horizontal,
        modifier = modifier.fillMaxSize(),
        content = content
    )
}