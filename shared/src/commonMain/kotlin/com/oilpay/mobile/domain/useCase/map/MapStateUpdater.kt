package com.oilpay.mobile.domain.useCase.map

import com.oilpay.mobile.core.updater.MapUpdater

internal interface MapStateUpdater {
    fun attach()
    fun detach()

    fun setMaxZoomPreference(value: Float)
    fun setMinZoomPreference(value: Float)
}

inline fun MapUpdater?.onMapScope(action: MapUpdater.() -> Unit) {
    val scope = this
    if (scope != null) {
        action(scope)
    }
}
