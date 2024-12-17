package com.oilpay.mobile.presentation.ui.splash.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.ui.splash.component.DefaultSplashComponent
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.logo
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.presentation.components.layout_helpers.CenteredColumn
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import org.jetbrains.compose.resources.imageResource

internal class SplashScreen(
    private val component: DefaultSplashComponent
) : ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {
        CenteredColumn(
            modifier = Modifier.background(OilPayTheme.colors.background),
            horizontal = Alignment.CenterHorizontally
        ) {
            Image(
                bitmap = imageResource(Res.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(250.dp)
            )
        }
    }
}
