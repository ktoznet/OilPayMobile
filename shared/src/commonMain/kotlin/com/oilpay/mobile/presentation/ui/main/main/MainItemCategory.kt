package com.oilpay.mobile.presentation.ui.main.main

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.tire
import com.oilpay.mobile.presentation.components.modifiers.noIndicationClickable
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import org.jetbrains.compose.resources.imageResource

@Composable
fun MainItemCategory(
    title: String,
    image: ImageBitmap,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(OilPayTheme.colors.backgroundContainer, OilPayTheme.shapes.default)
            .clip(OilPayTheme.shapes.default)
            .noIndicationClickable { onClick.invoke() }
    ) {
        Image(
            imageResource(Res.drawable.tire),
            contentDescription = null,
            modifier = Modifier
                .height(100.dp)
                .padding(start = 20.dp)
        )
        Canvas(
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.TopEnd), onDraw = {
                drawImage(
                    image = image,
                    dstOffset = IntOffset(x = 100, y = -120)
                )
            })
        Text(
            text = title,
            style = OilPayTheme.typography.mediumTitle,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 10.dp)
                .padding(bottom = 10.dp)
        )
    }
}