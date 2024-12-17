package com.oilpay.mobile.presentation.components.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.modifiers.noIndicationClickable
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

@Composable
fun InfoButton (
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .size(18.dp)
            .noIndicationClickable { onClick.invoke() }
            .then(modifier)
        ,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Outlined.Info,
            contentDescription = null,
            tint = OilPayTheme.colors.text
        )
    }
}