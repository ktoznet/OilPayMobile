package com.oilpay.mobile.presentation.ui.biometry

import com.oilpay.mobile.presentation.ui.biometry.component.IdentifyComponent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.safe
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.presentation.components.layout_helpers.CenteredColumn
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import com.oilpay.mobile.presentation.ui.biometry.component.DefaultIdentifyComponent
import org.jetbrains.compose.resources.painterResource

class IdentifyScreen(
    private val component: DefaultIdentifyComponent
): ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {

        IdentifyContent(component)
    }
}


@Composable
fun IdentifyContent(component: IdentifyComponent) {
    CenteredColumn(
        horizontal = Alignment.CenterHorizontally,
        vertical = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(OilPayTheme.colors.background)
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        CustomSpacer(21.dp)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(top = 83.dp, bottom = 191.dp)
        ) {
            Text(
                text = "Убедитесь, что ваше лицо находится в\nвыделенной области",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                color = Color.White,
            )

            FaceCircle()
            Text(
                text = "Следуйте инструкциям",
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.padding(top = 40.dp)
                )
        }
        Image(
            painter = painterResource(Res.drawable.safe),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 20.dp)
                .size(69.dp, 21.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color.Transparent)
                .clip(RoundedCornerShape(4.dp))
                .shadow(elevation = 4.dp)
        )
    }
}

@Composable
private fun FaceCircle() {
    val shape = RoundedCornerShape(50)
    Box(
        modifier = Modifier
            .padding(top = 30.dp)
            .size(320.dp)
            .background(Color(0xFF393939), shape)
            .border(3.dp, Color(0xFFFF7C1A), shape)
            .clip(shape)
    )
}