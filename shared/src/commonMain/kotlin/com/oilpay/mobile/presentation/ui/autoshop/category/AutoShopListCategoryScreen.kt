package com.oilpay.mobile.presentation.ui.autoshop.category

import AutoShopCategoryListComponent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.ui.autoshop.category.compose.AutoShopCategoryItem
import com.oilpay.mobile.presentation.components.layout_helpers.TitleAppBar
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

@Composable
fun AutoShopCategoryListScreen(
    component: AutoShopCategoryListComponent,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TitleAppBar(
                "аксессуары",
                "\nдля салона",
                isInverted = true,
                onBackClick = onBack
            )
        },
        containerColor = OilPayTheme.colors.background
        ) {
        LazyColumn(
            modifier = Modifier.padding(it).padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            items(component.categories) { item ->
                AutoShopCategoryItem(item) {
                    component.onCategorySelected(it)
                }
            }
        }
    }
}


