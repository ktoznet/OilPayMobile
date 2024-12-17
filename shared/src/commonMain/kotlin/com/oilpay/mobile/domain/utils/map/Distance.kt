package com.oilpay.mobile.domain.utils.map

import com.oilpay.mobile.core.utils.map.SphericalUtil
import com.oilpay.mobile.domain.entities.LatLng
import kotlin.math.roundToInt

infix fun LatLng.roundDistanceTo(latLng: LatLng): Int = computeDistance(this, latLng).roundToInt()

infix fun LatLng.distanceTo(latLng: LatLng): Double = computeDistance(this, latLng)

private fun computeDistance(from: LatLng, to: LatLng): Double {
    return SphericalUtil.computeDistanceBetween(from, to)
}
