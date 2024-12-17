package com.oilpay.mobile.presentation.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

@Composable
fun PrimaryButton(
    text: String,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        enabled = isEnabled,
        shape = OilPayTheme.shapes.default,
        colors = ButtonDefaults.buttonColors(
            containerColor = OilPayTheme.colors.secondary,
            contentColor = OilPayTheme.colors.onBackground,
            disabledContentColor = OilPayTheme.colors.text,
            disabledContainerColor = OilPayTheme.colors.outline
        ),
        modifier = Modifier.fillMaxWidth().height(40.dp).then(modifier)
    ) { Text(text) }
}