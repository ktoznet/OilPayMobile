package com.oilpay.mobile.core.utils.map

import android.graphics.PointF
import com.google.android.gms.maps.Projection
import com.oilpay.mobile.domain.entities.LatLng

actual typealias Projection = Projection

actual fun Projection.toScreenLatLng(point: Point) = LatLng(
    fromScreenLocation(
        /* point = */
        android.graphics.Point(
            /* x = */
            point.x.toInt(),
            /* y = */
            point.y.toInt()
        )
    )
)
actual typealias PlatformPoint = PointF

actual class Point actual constructor(val platformPoint: PlatformPoint) {
    actual val x: Float
        get() = platformPoint.x

    actual val y: Float
        get() = platformPoint.y

    actual constructor(x: Float, y: Float) : this(
        platformPoint = PointF(x, y)
    )
}
