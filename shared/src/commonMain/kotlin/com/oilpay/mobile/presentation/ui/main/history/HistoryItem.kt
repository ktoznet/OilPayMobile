package com.oilpay.mobile.presentation.ui.main.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GasMeter
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.layout_helpers.CenteredRow
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import com.oilpay.mobile.presentation.ui.main.history.HistoryElement

@Composable
fun HistoryItem(item: HistoryElement, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp)
            .then(modifier)
    ) {
        CenteredRow(
            horizontal = Arrangement.SpaceBetween
        ) {
            Text(item.gasName, style = OilPayTheme.typography.mediumTitle)
            Text("ID ${item.id}", style = OilPayTheme.typography.mediumTitle, fontStyle = FontStyle.Italic, color = OilPayTheme.colors.primary)
        }
        CustomSpacer(3.dp)
        CenteredRow(
            horizontal = Arrangement.SpaceBetween
        ) {
            Text(item.location, style = OilPayTheme.typography.smallLabel, modifier = Modifier.widthIn(max = 150.dp))
            Text(item.date, style = OilPayTheme.typography.smallLabel)
        }
        CustomSpacer(12.dp)
        CenteredRow(
            horizontal = Arrangement.SpaceBetween
        ) {
            Row {
                Row {
                    Icon(Icons.Default.GasMeter, null, tint = OilPayTheme.colors.onBackground, modifier = Modifier.size(14.dp))
                    CustomSpacer(3.dp)
                    Text(item.pump.toString(), style = OilPayTheme.typography.smallTitle)
                }
                CustomSpacer(10.dp)
                Text(item.fuelType, style = OilPayTheme.typography.smallTitle)
                CustomSpacer(10.dp)
                Text("${item.fuelAmount} л", style = OilPayTheme.typography.smallTitle)
            }
            Text("${item.price} сум", style = OilPayTheme.typography.smallTitle)
        }
    }
}