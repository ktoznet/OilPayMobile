package com.oilpay.mobile.presentation.ui.main.carddetail

import CardDetailComponent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.ui.main.main.Card
import com.oilpay.mobile.presentation.ui.main.main.CardItem

import com.oilpay.mobile.presentation.components.input.switch.SwitchWithLabel
import com.oilpay.mobile.presentation.components.layout_helpers.CenteredColumn
import com.oilpay.mobile.presentation.components.layout_helpers.TitleAppBar
import com.oilpay.mobile.presentation.components.modifiers.noIndicationClickable
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme



@Composable
fun CardDetailScreen(component: CardDetailComponent) {
    val card = component.card
    val hiddenCardNumber = card.cardNumber.replaceRange(0, card.cardNumber.length - 4, "*")

    Scaffold(
        topBar = { TitleAppBar(
            "Карта",
            secondaryText = hiddenCardNumber,
            onBackClick = { TODO("реализация назад кнопки") }
        )
                 },
        containerColor = OilPayTheme.colors.background
    ) { padding ->
        CenteredColumn(
            modifier = Modifier.padding(padding).padding(horizontal = 20.dp),
            vertical = Arrangement.Top
        ) {
            CardItem(card) {}
            CustomSpacer(25.dp)
            SwitchWithLabel(label = "Сделать карту основной",
                onInfoClick = {},
                checked = component.isMainCard,
                onCheckedChange = component::onSetMainCard
            )
            CustomSpacer(10.dp)
            SwitchWithLabel(
                label = "Мониторинг карты",
                onInfoClick = {},
                checked = component.isMonitoringEnabled,
                onCheckedChange = component::onToggleMonitoring
            )
            CustomSpacer(10.dp)
                Row(
                    modifier = Modifier.noIndicationClickable {  },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Outlined.Delete, null, tint = Color.Red)
                    CustomSpacer(5.dp)
                    Text("Удалить карту", color = Color.Red, style = OilPayTheme.typography.smallTitle)
                }
        }
    }

}