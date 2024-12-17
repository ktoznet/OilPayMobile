package com.oilpay.mobile.presentation.components.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

internal val LocalColors =
    compositionLocalOf<OilPayColors> { error("No colors provided! Make sure to wrap all usages of components in a OilPayTheme.") }

@Stable
private fun figmaColor(hex: String) =
    Color(color = hex.removePrefix("#").prependIndent("FF").toLong(radix = 16))

internal val pumpkinColor = figmaColor("#FF7C1A")
internal val aquaColor = figmaColor("#0079E0")
internal val lightGrayColor = figmaColor("#6A6A6A")
internal val signalBlackColor = figmaColor("#333333")
internal val blackBrownColor = figmaColor("#232222")
internal val partBlackColor = figmaColor("#121212")
internal val redColor = figmaColor("#EF233C")
internal val darkGrayColor = figmaColor("#393939")

interface OilPayColors {
    val primary: Color
    val onPrimary: Color
    val background: Color
    val backgroundContainer: Color
    val secondary: Color
    val error: Color
    val text: Color
    val outline: Color
    val surfaceContainer: Color
    val onBackground: Color
}

class OilPayColorsLight(
    override val primary: Color,
    override val onPrimary: Color,
    override val background: Color,
    override val backgroundContainer: Color,
    override val secondary: Color,
    override val error: Color,
    override val text: Color,
    override val outline: Color,
    override val surfaceContainer: Color,
    override val onBackground: Color
) : OilPayColors

fun darkColors() = OilPayColorsLight(
    primary = pumpkinColor,
    background = partBlackColor,
    secondary = aquaColor,
    error = redColor,
    backgroundContainer = blackBrownColor,
    text = lightGrayColor,
    outline = signalBlackColor,
    surfaceContainer = darkGrayColor,
    onBackground = Color.White,
    onPrimary = Color.White,
)



