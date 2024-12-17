package com.oilpay.mobile.presentation.ui.main.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import org.jetbrains.compose.resources.imageResource
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.humopayment
import com.oilpay.mobile.compose.resources.kapitalbank
import com.oilpay.mobile.presentation.components.modifiers.noIndicationClickable
import com.oilpay.mobile.presentation.components.layout_helpers.CenteredRow

@Composable
fun CardItem(card: Card, onClick: () -> Unit) {


    val formattedBalance = card.balance.reversed().chunked(3).joinToString(" ").reversed()

    val hiddenCardNumber = card.cardNumber.replaceRange(0, card.cardNumber.length - 4, "**** ")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .background(OilPayTheme.colors.backgroundContainer)
            .padding(15.dp)
            .noIndicationClickable { onClick.invoke() },
        verticalArrangement = Arrangement.SpaceBetween,
    ) {


        CenteredRow(
            horizontal = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    bitmap = imageResource(Res.drawable.humopayment), null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.sizeIn(minHeight = 24.dp, maxHeight = 24.dp)
                )
                CustomSpacer(5.dp)
                Text(hiddenCardNumber, style = OilPayTheme.typography.mediumLabel)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    bitmap = imageResource(Res.drawable.kapitalbank), null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.sizeIn(minHeight = 24.dp, maxHeight = 24.dp)
                )
                CustomSpacer(5.dp)
                Text(card.bankInfo.name, style = OilPayTheme.typography.smallLabel, color = OilPayTheme.colors.onBackground)
            }
        }

        Row {
            Column {
                Text("Карта ${card.paymentSystem.name}" , style = OilPayTheme.typography.smallTitle, color = OilPayTheme.colors.text)
                Text("$formattedBalance сум", style = OilPayTheme.typography.mediumDisplay)
            }
        }
    }
}