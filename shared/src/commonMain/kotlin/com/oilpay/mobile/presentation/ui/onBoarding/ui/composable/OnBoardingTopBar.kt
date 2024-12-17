package com.oilpay.mobile.presentation.ui.onBoarding.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.skip
import com.oilpay.mobile.presentation.components.text.TextLink
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun OnBoardingTopBar(
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextLink(
            text = stringResource(Res.string.skip),
            fontSize = 12.sp,
            fontWeight = 600,
            onClick = onClick
        )
    }
}