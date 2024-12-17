package com.oilpay.mobile.presentation.ui.autoshop.category.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.ui.autoshop.category.AutoShopCategory
import com.oilpay.mobile.presentation.components.modifiers.noIndicationClickable
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import com.oilpay.mobile.presentation.components.theme.WeightSpacer

@Composable
fun AutoShopCategoryItem(item: AutoShopCategory, onClick: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .noIndicationClickable { onClick.invoke(item.id) },
        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(Modifier.background(Color.DarkGray).size(65.dp))
        CustomSpacer(20.dp)
        Column {
            Text(item.title, style = OilPayTheme.typography.smallTitle)
            Text(
                item.desc,
                style = OilPayTheme.typography.smallLabel,
                modifier = Modifier.width(150.dp),
            )
        }
        WeightSpacer()
        Icon(
            Icons.AutoMirrored.Filled.ArrowForward,
            null,
            tint = OilPayTheme.colors.primary
        )
    }
}