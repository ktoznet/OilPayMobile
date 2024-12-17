package com.oilpay.mobile.presentation.ui.main.antiradar

import AntiRadarComponent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.map
import com.oilpay.mobile.presentation.components.buttons.IconBackButton
import com.oilpay.mobile.presentation.components.text.TwoColorText
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import org.jetbrains.compose.resources.imageResource



@Composable
fun AntiRadarScreen(component: AntiRadarComponent) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                 modifier = Modifier
                     .statusBarsPadding()
                     .fillMaxWidth()
                     .wrapContentHeight()
                     .align(Alignment.TopCenter)
                     .padding(horizontal = 20.dp)
                     .padding(top = 20.dp)
                     .zIndex(1000f)

            ) {
                IconBackButton(
                    icon = Icons.Default.ArrowBackIosNew,
                    modifier = Modifier.align(Alignment.CenterStart).size(50.dp).background(
                        OilPayTheme.colors.background, OilPayTheme.shapes.round)

                ) {
                    component.onBack()
                }
                TwoColorText(
                    "Анти",
                    "Радар",
                    spaceBar = "",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Image(
                imageResource(Res.drawable.map),
                null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
}