package com.oilpay.mobile.presentation.ui.main.main

import androidx.compose.material3.*
import androidx.compose.runtime.*
import MainScreenComponent
import androidx.compose.animation.VectorConverter
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Radar
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.nut
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.presentation.components.buttons.ClickableIcon
import com.oilpay.mobile.presentation.components.modifiers.noIndicationClickable
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import com.oilpay.mobile.presentation.ui.main.main.component.DefaultMainScreenComponent
import com.oilpay.mobile.presentation.ui.main.main.component.DefaultMainScreenComponent.BottomSheetType
import org.jetbrains.compose.resources.imageResource
class MainScreen(
    private val component: DefaultMainScreenComponent
): ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {

        MainScreenContent(component)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainScreenContent(component: MainScreenComponent) {

    val bottomSheetState by remember { derivedStateOf { component.showBottomSheet } }


    if (bottomSheetState != BottomSheetType.None) {
        ModalBottomSheet(
            onDismissRequest = {
                component.closeBottomSheet()
            }
        ) {
            when (bottomSheetState) {
                is BottomSheetType.MyCar -> MyCarContent()

                is BottomSheetType.Promotions -> PromotionsContent()

                is BottomSheetType.AddCard -> AddCardContent()

                else -> println("Неизвестное состояние BottomSheet")
            }
        }
    } else {
        println("BottomSheetType = None")
    }

    Scaffold(
        topBar = { AppBar(component) },
        containerColor = OilPayTheme.colors.background
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 20.dp)
        ) {

            val pagerState = rememberPagerState { if (component.card != null) 2 else 1 }

            HorizontalPager(
                state = pagerState,
                pageSpacing = 10.dp
            ) { page ->
                if (page == 0 && component.card != null) {
                    CardItem(component.card!!) { component.onCardDetail(component.card!!) }
                } else {
                    AddCardPage {
                        component.openBottomSheet(BottomSheetType.AddCard)
                    }
                }

            }
            CustomSpacer(8.dp)
            CardPagerIndicator(
                pagerState = pagerState
            )
            CustomSpacer(18.dp)
            CustomSearchBar(component = component)
            CustomSpacer(20.dp)
            AdContainer(component = component)
            CustomSpacer(20.dp)
            MainCategories(component = component)
        }
    }
}

@Composable
fun AppBar(component: MainScreenComponent) {
    Row(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .size(35.dp)
                .clip(RoundedCornerShape(100))
                .background(Color(0xff393939), RoundedCornerShape(100))
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            ClickableIcon(Icons.Default.Radar) { component.onAntiRadar() }
            ClickableIcon(Icons.Default.History) { component.onHistory() }
            ClickableIcon(Icons.Default.Notifications) { component.onNotifications() }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(component: MainScreenComponent) {
    SearchBar(
        query = component.searchQuery,
        onQueryChange = { component.onSearchQueryChange(it) },
        active = false,
        onActiveChange = { it },
        onSearch = { },
        shape = RoundedCornerShape(2.dp),
        colors = SearchBarDefaults.colors(containerColor = OilPayTheme.colors.backgroundContainer),
        leadingIcon = { Icon(Icons.Default.Search, null, tint = OilPayTheme.colors.text) },
        placeholder = { Text("Поиск", color = OilPayTheme.colors.text) },
        windowInsets = WindowInsets(0.dp),
    ) {

    }
}

@Composable
fun AdContainer(modifier: Modifier = Modifier,component: MainScreenComponent) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(OilPayTheme.colors.surfaceContainer, OilPayTheme.shapes.default)
            .clip(OilPayTheme.shapes.default),
        contentAlignment = Alignment.Center
    ) {
        Text("Рекламный баннер", style = OilPayTheme.typography.mediumTitle)
    }
}

@Composable
fun MainCategories(modifier: Modifier = Modifier,component: MainScreenComponent ) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally)
    ) {
        component.categories.forEach { category ->
            item {
                MainItemCategory(category, imageResource(Res.drawable.nut)) {
                    println("Клик по категории: $category")
                    component.onCategoryClick(category)
                }
            }
        }
    }
}


@Composable
private fun AddCardPage(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .background(OilPayTheme.colors.backgroundContainer)
            .noIndicationClickable { onClick.invoke() },
        contentAlignment = Alignment.Center
    ) {
        Text("+ Добавить карту", style = OilPayTheme.typography.largeTitle, color = OilPayTheme.colors.primary)
    }
}


@Composable
fun animatedColor(
    condition: Boolean,
    defaultColor: Color,
    targetColor: Color,
    animationSpec: AnimationSpec<Color> = spring(),
    label: String = "ColorAnimation",
    finishedListener: ((Color) -> Unit)? = null
): State<Color> {
    val targetValue = if (condition) targetColor else defaultColor
    val converter = remember(targetValue.colorSpace) {
        (Color.VectorConverter)(targetValue.colorSpace)
    }
    return animateValueAsState(
        targetValue, converter, animationSpec, label = label, finishedListener = finishedListener
    )
}

@Composable
fun PromotionsContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Функционал 'Акции'",
            style = MaterialTheme.typography.headlineSmall.copy(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .background(Color(0xFFEEEEEE))
                .padding(16.dp)
        ) {
            Text(
                text = "будет добавлен в следующих версиях, следите за обновлениями!",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
                lineHeight = 18.sp
            )
        }
    }
}

@Composable
fun MyCarContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Функционал 'Моё авто'",
            style = MaterialTheme.typography.headlineSmall.copy(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .background(Color(0xFFEEEEEE))
                .padding(16.dp)
        ) {
            Text(
                text = "Вы сможете добавить свой автомобиль и управлять им прямо в приложении",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
                lineHeight = 18.sp
            )
        }
    }
}

@Composable
fun AddCardContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Добавление карты",
            style = MaterialTheme.typography.headlineSmall.copy(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .background(Color(0xFFEEEEEE))
                .padding(16.dp)
        ) {
            Text(
                text = "Мы работаем над внедрением этого функционала. Скоро вы сможете добавить карту для удобной оплаты.",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
                lineHeight = 18.sp
            )
        }
    }
}