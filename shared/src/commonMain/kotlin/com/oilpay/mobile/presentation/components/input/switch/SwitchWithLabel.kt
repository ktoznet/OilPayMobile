package com.oilpay.mobile.presentation.components.input.switch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.buttons.InfoButton
import com.oilpay.mobile.presentation.components.input.switch.CustomSwitch
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import com.oilpay.mobile.presentation.components.layout_helpers.CenteredRow
@Composable
fun SwitchWithLabel(
    label: String,
    onInfoClick: () -> Unit,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    CenteredRow(
        horizontal = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(text = label , style = OilPayTheme.typography.smallTitle)
            InfoButton(onClick = onInfoClick)
        }
        CustomSwitch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}