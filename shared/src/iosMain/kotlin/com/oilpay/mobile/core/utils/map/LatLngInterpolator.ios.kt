package com.oilpay.mobile.core.utils.map

import com.oilpay.mobile.core.content.map.Marker
import com.oilpay.mobile.domain.entities.LatLng
import kotlinx.cinterop.ExperimentalForeignApi
import platform.QuartzCore.CATransaction

@OptIn(ExperimentalForeignApi::class)
actual fun animateMarker(
    marker: Marker,
    start: LatLng,
    destination: LatLng,
    onInterpolated: (LatLng) -> Unit
) {
    CATransaction.begin()
    CATransaction.setAnimationDuration(1.4)
    marker.position = destination.cValue
    CATransaction.commit()
}
