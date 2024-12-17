package com.oilpay.mobile.core.content.map

import cocoapods.GoogleMaps.GMSMarker
import com.oilpay.mobile.core.ext.MarkerImage
import com.oilpay.mobile.domain.entities.IOSLatLng
import com.oilpay.mobile.domain.entities.LatLng
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
actual typealias Marker = GMSMarker


@OptIn(ExperimentalForeignApi::class)
actual fun Marker.remove() {
    icon = null
    map = null
}

@OptIn(ExperimentalForeignApi::class)
actual fun Marker.updatePosition(latLng: LatLng) {
    position = latLng.cValue
}

@OptIn(ExperimentalForeignApi::class)
actual fun Marker.setIcon(markerImage: MarkerImage) {
    this.icon = markerImage
}

@OptIn(ExperimentalForeignApi::class)
actual val Marker.currentPosition: LatLng
    get() = LatLng(IOSLatLng(position))