package com.oilpay.mobile.domain.useCase.map

import com.oilpay.mobile.core.content.map.Marker
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
actual fun Marker?.inScope(action: Marker.() -> Unit) {
    val scope = this
    if (scope != null) {
        action(scope)
    }
}
