package com.oilpay.mobile.presentation.ui.biometry

import DefaultBiometryComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.faceid
import com.oilpay.mobile.compose.resources.fingerprint
import com.oilpay.mobile.compose.resources.location
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.presentation.components.alert.CustomAlertDialog
import com.oilpay.mobile.presentation.components.buttons.OutlinedPrimaryButton
import com.oilpay.mobile.presentation.components.buttons.PrimaryButton
import com.oilpay.mobile.presentation.components.layout_helpers.CenteredColumn
import com.oilpay.mobile.presentation.components.text.TwoColorText
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import com.oilpay.mobile.presentation.components.theme.WeightSpacer
import com.oilpay.mobile.presentation.components.theme.pumpkinColor
import org.jetbrains.compose.resources.imageResource

class BiometryScreen(
    private val component: DefaultBiometryComponent
): ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {
        BiometryContent(component)
    }
}


@Composable
fun BiometryContent(
    component: DefaultBiometryComponent
) {
    val biometryType by component.biometryType.collectAsState()
    val active = component.isAlertActive
    val title: String
    val subtitle: String
    val icon: ImageBitmap
    when (biometryType) {
        BiometryType.FACEID -> {
            title = "FACE ID"
            subtitle = "Face Id"
            icon = imageResource(Res.drawable.faceid)
        }

        BiometryType.TOUCHID -> {
            title = "ОТПЕЧАТКУ ПАЛЬЦА"
            subtitle = "отпечатка пальца"
            icon = imageResource(Res.drawable.fingerprint)
        }
    }


    CenteredColumn(
        modifier = Modifier
            .background(OilPayTheme.colors.background)
            .navigationBarsPadding()
            .padding(bottom = 20.dp)
            .padding(horizontal = 20.dp),
        vertical = Arrangement.SpaceBetween
    ) {
        WeightSpacer()
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                tint = pumpkinColor
            )
            CustomSpacer(40.dp)
            TwoColorText("Вход по", title)
            CustomSpacer(8.dp)
            Text("Разрешите вход с помощью $subtitle", style = OilPayTheme.typography.mediumLabel)
        }

        WeightSpacer()

        PrimaryButton("Разрешить", true) {
            component.onNavToIden()
        }

        CustomSpacer(8.dp)

        OutlinedPrimaryButton("В другой раз", true) {
            component.onBiometryToggle()
        }


//        ALERT DIALOG
        if (active) {
            CustomAlertDialog(onDismiss = {component.onAlertDismiss() }) {
                Icon(
                    bitmap = imageResource(Res.drawable.location),
                    contentDescription = null,
                    tint = OilPayTheme.colors.primary,
                    modifier = Modifier.size(100.dp)
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Доступ к геопозиции",
                        style = OilPayTheme.typography.largeTitle,
                        color = OilPayTheme.colors.onBackground
                    )
                    CustomSpacer(6.dp)
                    Text(
                        text = "Чтобы продолжить, включите на устройстве геолокацию",
                        textAlign = TextAlign.Center,
                        style = OilPayTheme.typography.mediumLabel
                    )
                }
                PrimaryButton("Включить") {
                    component.onConfirmationRequested()
                }
            }
        }
    }
}

