package com.oilpay.mobile.core.utils.map

import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator
import com.oilpay.mobile.domain.entities.LatLng
import com.oilpay.mobile.core.content.map.Marker

actual fun animateMarker(
    marker: Marker,
    start: LatLng,
    destination: LatLng,
    onInterpolated: (LatLng) -> Unit
) {
    ValueAnimator.ofFloat(0f, 1f).apply {
        duration = 1400
        interpolator = LinearInterpolator()
        addUpdateListener { animation ->
            try {
                val fraction = animation.animatedFraction
                val position = LatLngInterpolator.interpolate(fraction, start, destination)
                onInterpolated(position)
            } catch (ex: Exception) {
                // I don't care atm..
            }
        }
        start()
    }
}
