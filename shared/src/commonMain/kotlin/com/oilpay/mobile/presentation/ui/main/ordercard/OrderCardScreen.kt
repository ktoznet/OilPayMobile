package com.oilpay.mobile.presentation.ui.main.ordercard

import OrderCardComponent
import androidx.compose.foundation.layout.Arrangement
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
import com.oilpay.mobile.presentation.ui.main.main.Card
import com.oilpay.mobile.presentation.ui.main.main.CardBankInfo
import com.oilpay.mobile.presentation.ui.main.main.CardPaymentSystem
import com.oilpay.mobile.presentation.components.input.textfield.CustomTF
import com.oilpay.mobile.presentation.components.input.textfield.TextFieldType
import com.oilpay.mobile.presentation.components.layout_helpers.CenteredColumn
import com.oilpay.mobile.presentation.components.layout_helpers.TitleAppBar
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import com.oilpay.mobile.presentation.ui.identity.ui.auth.BottomContent
import com.oilpay.mobile.presentation.ui.smscode.SmsScreen


@Composable
fun OrderCardScreen(component: OrderCardComponent) {

    Scaffold(
        topBar = {
            TitleAppBar(
                primaryText = "Заполните",
                secondaryText = "Заявку",
                onBackClick = { TODO("реализовать кнопку назад") }
            )
        },
        bottomBar = {

            BottomContent(
                isNotEmpty = true,
                modifier = Modifier.padding(horizontal = 20.dp),
                checked = false,
                onChangeChecked = {}
            ) {  component.onSubmit() }



        },
        containerColor = OilPayTheme.colors.background,
    ) { padding ->
        CenteredColumn(
            vertical = Arrangement.spacedBy(20.dp, Alignment.Top),
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 20.dp)
        ) {
            CustomTF(
                type = TextFieldType.TEXT,
                label = "Фамилия",
                placeholder = "Ввод",
                value = component.surname,
                onValueChange = component::onSurnameChange
            )
            CustomTF(
                type = TextFieldType.TEXT,
                label = "Имя",
                placeholder = "Ввод",
                value = component.name,
                onValueChange = component::onNameChange
            )
            CustomTF(
                type = TextFieldType.PHONE,
                label = "Номер телефона",
                placeholder = "+998 00 000 00 00",
                value = component.phone,
                onValueChange = component::onPhoneChange
            )
        }
    }
}