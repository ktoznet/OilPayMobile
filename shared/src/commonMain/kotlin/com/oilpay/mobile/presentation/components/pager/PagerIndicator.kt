package com.oilpay.mobile.presentation.components.pager

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

@Composable
private fun PagerIndicator(isActive: Boolean) {

    val modifier = if (isActive) {
        Modifier.background(OilPayTheme.colors.primary)
    } else {
        Modifier.border(1.dp, OilPayTheme.colors.primary, shape = OilPayTheme.shapes.round)
    }

    Box(
        modifier = Modifier
            .size(10.dp)
            .clip(OilPayTheme.shapes.round)
            .then(modifier)
    )
}

@Composable
fun PagerIndicators(pageCount: Int, currentPage: Int, modifier: Modifier) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalArrangement = Arrangement.spacedBy(
            space = 20.dp,
            alignment = Alignment.CenterHorizontally
        ),
    ) {
        items(pageCount) { page ->
            PagerIndicator(page == currentPage)
        }
    }
}