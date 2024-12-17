package com.oilpay.mobile.presentation.components.layout_helpers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.buttons.IconBackButton
import com.oilpay.mobile.presentation.components.text.TwoColorText
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

@Composable
fun TitleAppBar(
    primaryText: String,
    secondaryText: String? = null,
    isInverted: Boolean = false,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .heightIn(min = 50.dp)
            .padding(20.dp)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        IconBackButton(
            icon = Icons.Default.ArrowBackIosNew,
            onClick = onBackClick,
//            modifier = Modifier
//                .padding(10.dp)
//                .size(24.dp)
//                .then(modifier)
        )
        if (secondaryText != null) {
            TwoColorText(
                primaryText,
                secondaryText,
                isInverted = isInverted
            )
        } else {
            Text(
                text = primaryText,
                style = OilPayTheme.typography.mediumDisplay
            )
        }
        CustomSpacer(24.dp)
    }
}