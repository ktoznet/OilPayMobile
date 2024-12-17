package com.oilpay.mobile.domain.utils.map

import com.oilpay.mobile.core.utils.map.SphericalUtil
import com.oilpay.mobile.domain.entities.LatLng

infix fun LatLng.headingTo(latLng: LatLng): Double = computeHeading(this, latLng)

private fun computeHeading(from: LatLng, to: LatLng) = SphericalUtil.computeHeading(from, to)
