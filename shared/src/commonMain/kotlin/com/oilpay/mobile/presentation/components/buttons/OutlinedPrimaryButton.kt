package com.oilpay.mobile.presentation.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

@Composable
fun OutlinedPrimaryButton(
    text: String,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        enabled = isEnabled,
        shape = OilPayTheme.shapes.default,
        border = BorderStroke(1.dp, OilPayTheme.colors.secondary),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Unspecified,
            contentColor = OilPayTheme.colors.secondary,
            disabledContentColor = OilPayTheme.colors.text,
            disabledContainerColor = Color.Unspecified
        ),
        modifier = Modifier.fillMaxWidth().height(40.dp).then(modifier)
    ) { Text(text) }
}