package com.oilpay.mobile.presentation.ui.main.sumovcard

import AddSumCardComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.buttons.PrimaryButton
import com.oilpay.mobile.presentation.components.input.switch.SwitchWithLabel
import com.oilpay.mobile.presentation.components.input.textfield.CustomTF
import com.oilpay.mobile.presentation.components.input.textfield.TextFieldType
import com.oilpay.mobile.presentation.components.layout_helpers.CenteredColumn
import com.oilpay.mobile.presentation.components.layout_helpers.TitleAppBar
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import com.oilpay.mobile.presentation.ui.main.main.Card
import com.oilpay.mobile.presentation.ui.main.main.CardBankInfo
import com.oilpay.mobile.presentation.ui.main.main.CardPaymentSystem

@Composable
fun AddSumCardScreen(component: AddSumCardComponent) {
    Scaffold(
        topBar = {
            TitleAppBar(
                "добавление",
                "карты",
                onBackClick = { TODO("назад кнопка") }
            )
        },
        bottomBar = {
            Box(
                Modifier
                    .navigationBarsPadding()
                    .padding(20.dp)
                    .imePadding()
            ) {
                PrimaryButton("Добавить") {
                    component.onAddCard()
                }
            }
        },
        containerColor = OilPayTheme.colors.background
    ) { padding ->
        CenteredColumn(
            vertical = Arrangement.spacedBy(20.dp, Alignment.Top),
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 20.dp)
        ) {
            var cardValue by remember { mutableStateOf("") }
            var cardDateValue by remember { mutableStateOf("") }
            CustomTF(
                type = TextFieldType.CARD,
                label = "Номер карты",
                placeholder = "0000 0000 0000 0000",
                value = cardValue,
                onValueChange = { cardValue = it }
            )
            CustomTF(
                type = TextFieldType.CARD_DATE,
                label = "Срок действия карты",
                placeholder = "ММ/ГГ",
                value = cardDateValue,
                onValueChange = { cardDateValue = it }
            )
            var checked by remember { mutableStateOf(false) }
            SwitchWithLabel("Сделать карту основной", {} , checked) { checked = it }
        }
    }
}
