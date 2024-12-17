package com.oilpay.mobile.presentation.ui.smscode

import SmsCodeComponent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oilpay.mobile.presentation.components.buttons.PrimaryButton
import com.oilpay.mobile.presentation.components.input.textfield.CodeField
import com.oilpay.mobile.presentation.components.input.textfield.CodeStatus
import com.oilpay.mobile.presentation.components.layout_helpers.CenteredColumn
import com.oilpay.mobile.presentation.components.text.TextLink
import com.oilpay.mobile.presentation.components.text.TwoColorText
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import com.oilpay.mobile.presentation.components.theme.WeightSpacer


@Composable
fun SmsScreen(component: SmsCodeComponent) {
    val state = component.state

    CenteredColumn(
        horizontal = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(OilPayTheme.colors.background)
            .padding(horizontal = 20.dp)
            .navigationBarsPadding()
            .padding(bottom = 20.dp)
            .imePadding()
    ) {
        WeightSpacer()
        TwoColorText(
            "введите", "смс-код"
        )
        Text(
            "Код для подтверждения был отправлен на номер \n +998000000000",
            style = OilPayTheme.typography.mediumLabel,
            textAlign = TextAlign.Center
        )
        CustomSpacer(40.dp)
        CodeField(
            value = state.smsValue,
            onValueChange = component::onSmsValueChange,
            length = 5,
            status = state.codeStatus
        )
        CustomSpacer(8.dp)

        Crossfade(state.isTimeEnd) { isExpired ->
            if (isExpired) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextLink("Еще раз отправить код") {}
                    Text("или", fontSize = 12.sp)
                    TextLink("Связаться с оператором") {}
                }
            } else {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val time = when {
                        (state.time >= 60) -> "1:00"
                        (state.time < 10) -> "0:0$state.time"
                        (state.time in 11..59) -> ""
                        else -> "0:$state.time"
                    }
                    Text("Вы можете запросить новый код через ", style = OilPayTheme.typography.mediumLabel)
                    TextLink(time, fontWeight = 600) {}
                }
            }
        }
        WeightSpacer()

        PrimaryButton(
            text = "Подтвердить",
            isEnabled = state.isCorrect,
            onClick = component::onConfirm
        )

    }
}