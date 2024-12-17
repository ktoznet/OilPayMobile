package com.oilpay.mobile.presentation.components.input.switch

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.modifiers.noIndicationClickable
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

@Composable
fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val transition = updateTransition(targetState = checked, label = "Switch Transition")

    val thumbOffset by transition.animateDp(
        transitionSpec = { tween(durationMillis = 300) },
        label = "Thumb Offset"
    ) { state ->
        if (state) 20.dp else 0.dp
    }

    val trackColorContainer by transition.animateColor(
        transitionSpec = { tween(durationMillis = 300) },
        label = "Track Color"
    ) { state ->
        if (state) OilPayTheme.colors.secondary else OilPayTheme.colors.backgroundContainer
    }
    val trackColorItem by transition.animateColor(
        transitionSpec = { tween(durationMillis = 300) },
        label = "Track Color"
    ) { state ->
        if (state) OilPayTheme.colors.onBackground else OilPayTheme.colors.text
    }

    Box(
        modifier = Modifier
            .width(46.dp)
            .height(24.dp)
            .background(trackColorContainer, shape = RoundedCornerShape(100.dp))
            .noIndicationClickable { onCheckedChange(!checked) }
            .padding(2.dp)
            .then(modifier)
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .offset(x = thumbOffset)
                .background(trackColorItem, shape = CircleShape)
        )
    }
}