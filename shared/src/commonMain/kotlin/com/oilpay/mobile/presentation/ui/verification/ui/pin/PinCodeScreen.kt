package com.oilpay.mobile.presentation.ui.verification.ui.pin

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Backspace
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.ui.verification.component.pin.DefaultPinCodeComponent
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.presentation.components.WeightSpacer
import com.oilpay.mobile.presentation.components.buttons.PrimaryButton
import com.oilpay.mobile.presentation.components.layout_helpers.CenteredColumn
import com.oilpay.mobile.presentation.components.modifiers.noIndicationClickable
import com.oilpay.mobile.presentation.components.text.TwoColorText
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

class PinCodeScreen(
    private val component: DefaultPinCodeComponent
): ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {
        val state by component.store.container.stateFlow.collectAsState()

        PincodeContent(false,component)
    }
}


class PincodeRepeatScreen(
    private val component: DefaultPinCodeComponent
): ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {
        val state by component.store.container.stateFlow.collectAsState()

        PincodeContent(true,component)
    }
}


@Composable
fun PincodeContent(isRepeat: Boolean,  component: DefaultPinCodeComponent) {
    val pin by component.pin.collectAsState()


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
            defaultText = if (!isRepeat) "придумайте" else "подтвердите", "код"
        )
        Text(
            if (!isRepeat) "Для быстрого входа в приложение" else "Для подтверждения правильности ввода",
            style = OilPayTheme.typography.mediumLabel,
            textAlign = TextAlign.Center
        )
        CustomSpacer(66.dp)
        PinCodeField(pin)
        CustomSpacer(66.dp)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.Center,

            ) {

//            Refactor??
            items(12) {
                val tt = when (it) {
                    9 -> ""
                    10 -> "0"
                    11 -> "delete"
                    else -> (it + 1).toString()
                }
                NumberItem(tt, tt == "delete") { number ->
                    if (number == "delete") component.onDeleteClick()
                    else component.onDigitClick(tt)
                }
            }
        }


        CustomSpacer(40.dp)
        PrimaryButton("Подтвердить", isEnabled = pin.length == 4) {
                component.onConfirm()
        }
    }
}


@Composable
fun NumberItem(text: String, isDelete: Boolean, onClick: (String) -> Unit) {
    Box(
        modifier = Modifier.size(105.dp, 70.dp),
        contentAlignment = Alignment.Center
    ) {
        if (isDelete)
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.Backspace,
                contentDescription = null,
                tint = OilPayTheme.colors.onBackground,
                modifier = Modifier
                    .noIndicationClickable { onClick.invoke("delete") }
            ) else {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                style = OilPayTheme.typography.largeTitle,
                color = OilPayTheme.colors.onBackground,
                modifier = Modifier
                    .noIndicationClickable { onClick.invoke(text) }
            )
        }
    }
}

@Composable
fun PinCodeField(
    value: String,
    modifier: Modifier = Modifier
) {
    BasicTextField(
        modifier = modifier,
        value = value,
        singleLine = true,
        onValueChange = {},
        decorationBox = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    repeat(4) { index ->
                        val number = value.getOrNull(index)?.toString() ?: ""

                        Crossfade(number != "") { num ->
                            Box(
                                modifier = Modifier.size(20.dp, 30.dp),
                                contentAlignment = Alignment.Center
                            ) {

                                if (num) {
                                    Text(
                                        text = number,
                                        textAlign = TextAlign.Center,
                                        style = OilPayTheme.typography.largeTitle,
                                        color = OilPayTheme.colors.primary
                                    )
                                } else {
                                    Box(
                                        Modifier.size(15.dp)
                                            .background(OilPayTheme.colors.text, RoundedCornerShape(100))
                                    )
                                }
                            }

                        }
                    }
                }
            }
        }
    )
}
