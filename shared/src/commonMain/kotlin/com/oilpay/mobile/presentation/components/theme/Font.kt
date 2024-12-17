package com.oilpay.mobile.presentation.components.theme

import androidx.compose.runtime.Composable

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.montserrat_bold
import com.oilpay.mobile.compose.resources.montserrat_bolditalic
import com.oilpay.mobile.compose.resources.montserrat_regular
import com.oilpay.mobile.compose.resources.montserrat_semibold
import org.jetbrains.compose.resources.Font


@Composable
internal fun OilPayFont(): OilPayFonts {
    val montserratRegular = Font(
        Res.font.montserrat_regular,
        weight = regularW
    )
    val montserratSemibold = Font(
        Res.font.montserrat_semibold,
        weight = boldW
    )
    val montserratBold = Font(
        Res.font.montserrat_bold,
        weight = blackW
    )
    val montserratBoldItalic = Font(
        Res.font.montserrat_bolditalic,
        style = FontStyle.Italic,
        weight = blackW
    )


    return OilPayFonts(
        FontFamily(
            montserratRegular,
            montserratSemibold,
            montserratBold,
            montserratBoldItalic
        )
    )
}

class OilPayFonts(
    val montserrat: FontFamily
)

internal val regularW = FontWeight(400)
internal val boldW = FontWeight(600)
internal val blackW = FontWeight(700)
