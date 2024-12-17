package com.oilpay.mobile.domain.utils.map

import com.oilpay.mobile.core.utils.map.SphericalUtil
import com.oilpay.mobile.domain.entities.LatLng

fun computeOffset(from: LatLng, distance: Double, heading: Double): LatLng {
    return SphericalUtil.computeOffset(from, distance, heading)
}
