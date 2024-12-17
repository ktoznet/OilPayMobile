package com.oilpay.mobile.domain.entities

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import com.oilpay.mobile.core.content.map.Marker
import com.oilpay.mobile.core.content.map.remove
import com.oilpay.mobile.domain.entities.MarkerOptions
import com.oilpay.mobile.core.updater.MapUpdater
import com.oilpay.mobile.presentation.components.rememberMutableState

@Composable
fun rememberSimpleMarker(
    mapUpdater: MapUpdater,
    markerOptions: () -> MarkerOptions
): Marker? {
    val updatedMarkerOptions by rememberUpdatedState(markerOptions)

    var marker by rememberMutableState<Marker?> { null }

    DisposableEffect(Unit) {
        marker = mapUpdater.addMarker(markerOptions = updatedMarkerOptions())

        onDispose {
            marker?.remove()
        }
    }

    return marker
}
