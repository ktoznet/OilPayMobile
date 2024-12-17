package com.oilpay.mobile.core.utils.map

import androidx.compose.ui.graphics.Color
import platform.UIKit.UIColor

fun Color.toUIColor(): UIColor {
    val maxColorValue = 0xFF
    return UIColor(
        red = red.toDouble() / maxColorValue,
        green = green.toDouble() / maxColorValue,
        blue = blue.toDouble() / maxColorValue,
        alpha = alpha.toDouble() / maxColorValue
    )
}
