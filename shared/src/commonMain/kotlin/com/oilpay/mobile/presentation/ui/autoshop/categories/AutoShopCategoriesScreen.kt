
package com.oilpay.mobile.presentation.ui.autoshop.categories

import DefaultAutoShopCategoriesComponent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.ui.autoshop.categories.compose.AutoShopListItem
import com.oilpay.mobile.presentation.components.layout_helpers.TitleAppBar
import com.oilpay.mobile.presentation.ui.autoshop.categories.component.AutoShopCategoriesComponent


class AutoShopCategoriesScreen(
    private val component: DefaultAutoShopCategoriesComponent
): ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {
        AutoShopCategoriesComponent(component, { component.onBack() } )
    }
}


//fun AutoShopCategoriesEntry(
//    componentContext: AppComponentContext,
//    onNavigateToCategory: (Int) -> Unit,
//    onBack: () -> Unit
//): AutoShopCategoriesComponent {
//    return DefaultAutoShopCategoriesComponent(
//        componentContext = componentContext,
//        onCategorySelected = onNavigateToCategory,
//    )
//}

@Composable
fun AutoShopCategoriesComponent(component: AutoShopCategoriesComponent, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TitleAppBar(
                "авто -",
                "магазин",
                isInverted = true,
                onBackClick = onBack
            )
        },
        containerColor = Color(0xff121212)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(20.dp),
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(component.categories) { item ->
                AutoShopListItem(item) { component.onCategorySelected(item.id) }
            }
        }
    }

}


