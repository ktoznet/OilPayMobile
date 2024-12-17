package com.oilpay.mobile.core.content.map

import com.oilpay.mobile.core.ext.MarkerImage
import com.oilpay.mobile.domain.entities.LatLng

actual typealias Marker = com.google.android.gms.maps.model.Marker

actual fun Marker.remove() = remove()

actual fun Marker.updatePosition(latLng: LatLng) {
    position = latLng.platform
}

actual fun Marker.setIcon(markerImage: MarkerImage) {
    this.setIcon(markerImage)
}

actual val Marker.currentPosition: LatLng
    get() = LatLng(position)
