package com.oilpay.mobile.presentation.ui.autoshop.detail

import AutoShopDetailComponent
import DefaultAutoShopDetailComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.ui.autoshop.detail.compose.AutoShopManufacturerItem
import com.oilpay.mobile.presentation.components.buttons.IconBackButton
import com.oilpay.mobile.presentation.components.buttons.PrimaryButton
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme



val shape = RoundedCornerShape(100)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoShopDetailContent(
    component: AutoShopDetailComponent,
    onBack: () -> Unit
) {
    val listState = rememberLazyGridState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CollapsableAppBar(scrollBehavior,onBack = onBack)
        },
        containerColor = OilPayTheme.colors.background,
        bottomBar = {
            Box(
                modifier = Modifier.navigationBarsPadding().fillMaxWidth().height(85.dp)
                    .clip(RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp)).padding(horizontal = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                PrimaryButton("Показать на карте") {
                    component.onShowOnMapClick()
                }
            }

        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomSpacer(50.dp)
            Text(
                text ="LOREM IPSUM",
                style = OilPayTheme.typography.mediumDisplay,
                color = OilPayTheme.colors.primary,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                modifier = Modifier.width(150.dp),
                style = OilPayTheme.typography.smallLabel,
                textAlign = TextAlign.Center
            )
            LazyVerticalGrid(
                state = listState,
                columns = GridCells.Fixed(2),

                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
                horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally),
                contentPadding = PaddingValues(20.dp)
            ) {
                items(component.manufacturerDetails) { item ->
                    Box(contentAlignment = Alignment.Center) {
                        AutoShopManufacturerItem(item) {}
                    }
                }
            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollapsableAppBar(ss: TopAppBarScrollBehavior,    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Color(0xff393939))
            .statusBarsPadding()
            .fillMaxWidth()
            .height(130.dp)

    ) {
        IconBackButton(
            icon = Icons.Default.AlternateEmail,
            modifier = Modifier.padding(20.dp),
            { onBack()}
        )
        Box(
            modifier = Modifier
                .offset(y = 40.dp)
                .background(Color(0xff393939), shape)
                .border(3.dp, Color(0xff121212), shape)
                .size(80.dp)
                .clip(shape)
                .align(Alignment.BottomCenter)
        )
    }

}