package com.oilpay.mobile.presentation.ui.autoshop.map

import AutoShopMapComponent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.map
import com.oilpay.mobile.presentation.components.buttons.IconBackButton
import org.jetbrains.compose.resources.imageResource



@Composable
private fun AutoShopMapContent(
    id: Int,
    component: AutoShopMapComponent
) {
    Box(modifier = Modifier.fillMaxSize()) {
        IconBackButton(
            icon = Icons.Default.ArrowBackIosNew,
            modifier = Modifier.statusBarsPadding().padding(20.dp).zIndex(1000f)
        ) {
            component.onBack()
        }
        Image(
            imageResource(Res.drawable.map),
            null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}