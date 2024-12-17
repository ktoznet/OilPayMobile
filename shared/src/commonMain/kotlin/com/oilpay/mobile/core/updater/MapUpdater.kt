package com.oilpay.mobile.core.updater

import androidx.compose.runtime.Stable
import com.oilpay.mobile.domain.repository.MapPaddingDecorator
import com.oilpay.mobile.domain.entities.MarkerOptions
import com.oilpay.mobile.domain.entities.LatLng
import com.oilpay.mobile.core.content.map.Marker
import kotlinx.coroutines.flow.SharedFlow

@Stable
interface MapUpdater {
    val paddingDecorator: MapPaddingDecorator
    val clickedMarker: SharedFlow<Marker?>

    fun isInitialCameraAnimation(): Boolean
    fun resetLastLocation()

    fun addMarker(markerOptions: MarkerOptions): Marker?

    fun zoomIn()
    fun zoomOut()

    fun animateCurrentLocation(target: LatLng, zoom: Float, bearing: Float)
    fun animateCamera(target: LatLng, zoom: Float, bearing: Float)
    fun animateTarget(
        target: LatLng,
        zoom: Float? = null,
        onFinish: () -> Unit = {},
        onCancel: () -> Unit = {}
    )

    fun animateZoom(zoom: Float)
}
