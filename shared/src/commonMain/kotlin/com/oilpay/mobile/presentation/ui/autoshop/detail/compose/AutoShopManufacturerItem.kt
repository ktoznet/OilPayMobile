package com.oilpay.mobile.presentation.ui.autoshop.detail.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.ui.autoshop.detail.AutoShopManufacturerDetail
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

@Composable
fun AutoShopManufacturerItem(item: AutoShopManufacturerDetail, onClick: () -> Unit) {
    Column(
        modifier = Modifier.sizeIn(maxWidth = 150.dp, minHeight = 220.dp)
    ) {
        Box(Modifier.size(150.dp).background(OilPayTheme.colors.backgroundContainer))
        CustomSpacer(10.dp)
        Text(item.title, style = OilPayTheme.typography.smallTitle)
        CustomSpacer(3.dp)
        if (item.discount != null) {
            Text(item.discount + " сум", style = OilPayTheme.typography.mediumLabel, color = OilPayTheme.colors.primary)
            CustomSpacer(2.dp)
            Text(item.price + " сум",
                style = OilPayTheme.typography.smallLabel, textDecoration = TextDecoration.LineThrough)
        } else {
            Text(item.price + " сум", style = OilPayTheme.typography.mediumLabel, color = OilPayTheme.colors.primary)
        }

    }
}