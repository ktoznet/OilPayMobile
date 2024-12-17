package com.oilpay.mobile.presentation.components.buttons

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.oilpay.mobile.presentation.components.modifiers.noIndicationClickable
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

@Composable
fun ClickableIcon(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        modifier = Modifier
            .noIndicationClickable { onClick.invoke() }
            .then(modifier),
        tint = OilPayTheme.colors.onBackground
    )
}