package com.oilpay.mobile.presentation.components.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

class OilPayShapes(
    val extraSmall: Shape,
    val default: Shape,
    val large: Shape,
    val round: Shape,
)

internal fun OilPayShape() = OilPayShapes(
    extraSmall = RoundedCornerShape(1.dp),
    default = RoundedCornerShape(2.dp),
    large = RoundedCornerShape(10.dp),
    round = RoundedCornerShape(100)
)

class TrapezoidShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: androidx.compose.ui.unit.LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(size.width, 0f)
            lineTo(size.width - 60F, size.height)
            lineTo(0f, size.height)
            close()
        }
        return Outline.Generic(path)
    }
}