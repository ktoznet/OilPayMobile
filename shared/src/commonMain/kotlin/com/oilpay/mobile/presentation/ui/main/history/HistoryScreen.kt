package com.oilpay.mobile.presentation.ui.main.history

import HistoryComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.layout_helpers.TitleAppBar
import com.oilpay.mobile.presentation.components.theme.OilPayTheme



@Composable
fun HistoryScreen(component: HistoryComponent) {
    Scaffold(
        topBar = { TitleAppBar(
            primaryText = "История",
            secondaryText = "Покупок",
            onBackClick = { component.onBack() }
        ) },
        containerColor = OilPayTheme.colors.background
    ) { padding ->
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(horizontal = 20.dp)
            ) {
                itemsIndexed(component.historyItems) { index, item ->
                    Column {
                        HistoryItem(item)
                        if (index != component.historyItems.size - 1) {
                            Box(modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp).height(1.dp).background(OilPayTheme.colors.backgroundContainer))
                        }
                    }
                }
            }
        }
}
