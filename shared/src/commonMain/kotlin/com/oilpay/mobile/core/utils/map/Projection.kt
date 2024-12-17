package com.oilpay.mobile.core.utils.map

import com.oilpay.mobile.domain.entities.LatLng


expect class Projection

expect fun Projection.toScreenLatLng(point: Point): LatLng

expect class PlatformPoint

expect class Point(platformPoint: PlatformPoint) {
    val x: Float
    val y: Float

    constructor(x: Float, y: Float)
}
