package com.oilpay.mobile.domain.entities

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import com.oilpay.mobile.core.content.map.Marker
import com.oilpay.mobile.core.content.map.remove
import com.oilpay.mobile.core.ext.MarkerImage
import com.oilpay.mobile.core.updater.MapUpdater
import com.oilpay.mobile.presentation.components.rememberMutableState
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun rememberIconMarker(
    mapUpdater: MapUpdater,
    position: LatLng,
    icon: () -> MarkerImage,
    zIndex: Float = 0f,
    title: String? = null,
    onMarkerClick: () -> Unit
): Marker? {
    val updatedOnMarkerClick by rememberUpdatedState(onMarkerClick)
    val updatedIcon by rememberUpdatedState(icon)

    var marker by rememberMutableState<Marker?> { null }

    LaunchedEffect(marker) {
        mapUpdater.clickedMarker
            .filter { it == marker }
            .onEach { updatedOnMarkerClick() }
            .launchIn(this)
    }

    DisposableEffect(position, title) {
        marker = mapUpdater.addMarker(
            MarkerOptions(
                position = position,
                icon = updatedIcon(),
                zIndex = zIndex,
                title = title
            )
        )

        onDispose {
            marker?.remove()
        }
    }

    return marker
}
