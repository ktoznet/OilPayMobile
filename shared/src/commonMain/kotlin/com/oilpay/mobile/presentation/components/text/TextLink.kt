package com.oilpay.mobile.presentation.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.oilpay.mobile.presentation.components.modifiers.noIndicationClickable
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

@Composable
fun TextLink(
    text: String,
    fontSize: TextUnit = 10.sp,
    fontWeight: Int = 500,
    textDecoration: TextDecoration = TextDecoration.None,
    onClick: () -> Unit
) {
    Text(
        text,
        fontSize = fontSize,
        fontWeight = FontWeight(fontWeight),
        color = OilPayTheme.colors.secondary,
        textDecoration = textDecoration,
        modifier = Modifier.noIndicationClickable(onClick),
        style = OilPayTheme.typography.smallLabel
    )
}