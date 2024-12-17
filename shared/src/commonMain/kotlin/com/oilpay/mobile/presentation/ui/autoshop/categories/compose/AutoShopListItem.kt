package com.oilpay.mobile.presentation.ui.autoshop.categories.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.ui.autoshop.categories.AutoShopCategories
import com.oilpay.mobile.presentation.components.modifiers.noIndicationClickable
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

@Composable
fun AutoShopListItem(item: AutoShopCategories, onClick: (Int) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(150.dp)
            .background(OilPayTheme.colors.backgroundContainer)
            .padding(15.dp)
            .noIndicationClickable { onClick.invoke(item.id) }
    ) {
//        Image()
        Box(Modifier.weight(1f))
        Text(item.title, style = OilPayTheme.typography.smallTitle, textAlign = TextAlign.Center)
    }
}