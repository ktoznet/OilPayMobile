package com.oilpay.mobile.presentation.ui.main.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import kotlin.math.abs

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardPagerIndicator(
    pagerState: PagerState,
) {
    val MULTIPLIER_SELECTED_PAGE = 2

    val screenSize = remember { mutableStateOf(1) }
    val baseWidth = ((screenSize.value.toDouble() / 5) / pagerState.pageCount)

    val offsetIntPart = pagerState.currentPageOffsetFraction.toInt()
    val offsetFractionalPart = pagerState.currentPageOffsetFraction - offsetIntPart
    val currentPage = pagerState.currentPage + offsetIntPart
    val targetPage =
        if (pagerState.currentPageOffsetFraction < 0) currentPage - 1 else currentPage + 1
    val currentPageWidth =
        baseWidth * (1 + (1 - abs(offsetFractionalPart)) * MULTIPLIER_SELECTED_PAGE)
    val targetPageWidth = baseWidth * (1 + abs(offsetFractionalPart) * MULTIPLIER_SELECTED_PAGE)
    val arrangement =
        if (pagerState.pageCount <= 2) Arrangement.spacedBy(8.dp) else Arrangement.SpaceBetween
    Layout(
        content = {
            Row(
                modifier = Modifier.height(5.dp).fillMaxWidth(),
                horizontalArrangement = arrangement
            ) {
                repeat(pagerState.pageCount) { iteration ->

                    val width = when (iteration) {
                        currentPage -> currentPageWidth
                        targetPage -> targetPageWidth
                        else -> baseWidth
                    }
                    val animatedColor by animatedColor(
                        iteration == currentPage,
                        OilPayTheme.colors.backgroundContainer,
                        OilPayTheme.colors.secondary
                    )
                    Box(
                        modifier = Modifier
                            .width(width.dp)
                            .background(animatedColor)
                            .height(3.dp)
                    )
                }
            }
        },
        measurePolicy = { measurables, constraints ->
            val width = constraints.maxWidth
            screenSize.value = width
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }

            layout(width, 0) {
                var yPosition = 0
                placeables.forEach { placeable ->
                    placeable.placeRelative(x = 0, y = yPosition)
                    yPosition += placeable.height
                }
            }
        }
    )
}