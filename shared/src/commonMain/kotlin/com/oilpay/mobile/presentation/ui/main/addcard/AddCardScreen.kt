package com.oilpay.mobile.presentation.ui.main.addcard

import AddCardComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oilpay.mobile.presentation.ui.main.ordercard.OrderCardScreen
import com.oilpay.mobile.presentation.ui.main.sumovcard.AddSumCardScreen
import com.oilpay.mobile.presentation.components.buttons.PrimaryButton
import com.oilpay.mobile.presentation.components.layout_helpers.TitleAppBar
import com.oilpay.mobile.presentation.components.modifiers.noIndicationClickable
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme




@Composable
fun AddCardScreen(component: AddCardComponent) {
    Scaffold(
        topBar = {
            TitleAppBar(
                "добавить",
                "карту",
                onBackClick = { TODO("реализовать кнопку назад") }
            )
        },
        bottomBar = {
            AddCardBottomContent(component)
        },
        containerColor = OilPayTheme.colors.background
    ) {
        Column(Modifier.padding(it)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp)
                    .background(OilPayTheme.colors.backgroundContainer, RoundedCornerShape(2.dp))
                    .clip(RoundedCornerShape(2.dp))
                    .padding(20.dp)
                    .noIndicationClickable { component.onAddOilPayCard() }

                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("OilPay карта", style = OilPayTheme.typography.largeTitle, color = OilPayTheme.colors.onBackground)
                Icon(Icons.Default.ArrowForward, contentDescription = null, tint = OilPayTheme.colors.primary)
            }
            CustomSpacer(15.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp)
                    .background(OilPayTheme.colors.backgroundContainer, RoundedCornerShape(2.dp))
                    .clip(RoundedCornerShape(2.dp))
                    .padding(20.dp)
                    .noIndicationClickable { component.onAddSumCard() }
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Сумовая карта", style = OilPayTheme.typography.largeTitle, color = OilPayTheme.colors.onBackground)
                Icon(Icons.Default.ArrowForward, contentDescription = null, tint = OilPayTheme.colors.primary)
            }
        }
    }
}

@Composable
private fun AddCardBottomContent(component: AddCardComponent) {
    Column(
        modifier = Modifier
            .navigationBarsPadding()
            .padding(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(65.dp, 40.dp)
                    .background(OilPayTheme.colors.surfaceContainer,RoundedCornerShape(2.dp))
                    .clip(RoundedCornerShape(2.dp))
                ,
                contentAlignment = Alignment.Center
            ) {
                Text("(Дизайн карты)", fontSize= 7.sp, color = OilPayTheme.colors.onBackground)
            }
            CustomSpacer(20.dp)
            Text(
                text = "Заказав карту OilPay вы сможете получать множество акций и кешбеков!",
                style = OilPayTheme.typography.mediumLabel
            )
        }
        CustomSpacer(20.dp)
        PrimaryButton(
            "Заказать карту OilPay"
        ) {
            component.onOrderCard()
        }
    }
}