package com.oilpay.mobile.core.content.map

import com.oilpay.mobile.core.ext.MarkerImage
import com.oilpay.mobile.domain.entities.LatLng

expect class Marker


expect fun Marker.remove()

expect fun Marker.updatePosition(latLng: LatLng)
expect fun Marker.setIcon(markerImage: MarkerImage)
expect val Marker.currentPosition: LatLng