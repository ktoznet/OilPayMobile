package com.oilpay.mobile.core.ext

import com.oilpay.mobile.core.utils.map.Projection

actual val GoogleMap.zoom: Float
    get() = cameraPosition.zoom

actual val GoogleMap.projection: Projection
    get() = projection

actual fun GoogleMap.updatePadding(left: Int, top: Int, right: Int, bottom: Int) {
    setPadding(left, top, right, bottom)
}
