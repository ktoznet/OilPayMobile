package com.oilpay.mobile.presentation.ui.main.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.NotificationAdd
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

@Composable
fun NotificationItem(item: NotificationElement, modifier: Modifier = Modifier) {

    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp).then(modifier),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        // Icon
        NotificationIcon(type = item.type)

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = item.title, style = OilPayTheme.typography.mediumTitle)
            Text(text = item.desc, style = OilPayTheme.typography.mediumLabel, color = OilPayTheme.colors.text, modifier = Modifier.height(30.dp))
            Text(text = item.date, style = OilPayTheme.typography.smallLabel, color = OilPayTheme.colors.text)
        }
    }
}

@Composable
private fun NotificationIcon(type: NotificationType) {
    val icon = when (type) {
        NotificationType.Insurance -> Icons.Outlined.NotificationAdd
        NotificationType.Fine -> Icons.Outlined.NotificationAdd
        NotificationType.Tinting -> Icons.Outlined.NotificationAdd
        NotificationType.Important -> Icons.Outlined.NotificationAdd
    }

    Box(
        modifier = Modifier
            .size(40.dp)
            .background(OilPayTheme.colors.backgroundContainer, OilPayTheme.shapes.round)
            .clip(OilPayTheme.shapes.round),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = OilPayTheme.colors.text
        )
    }
}