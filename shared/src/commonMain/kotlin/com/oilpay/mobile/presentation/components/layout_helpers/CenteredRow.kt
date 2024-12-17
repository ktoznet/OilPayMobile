package com.oilpay.mobile.presentation.components.layout_helpers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CenteredRow(
    vertical: Alignment.Vertical = Alignment.CenterVertically,
    horizontal: Arrangement.Horizontal = Arrangement.Start,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = vertical,
        horizontalArrangement = horizontal,
        modifier = Modifier.fillMaxWidth().then(modifier),
        content = content
    )
}