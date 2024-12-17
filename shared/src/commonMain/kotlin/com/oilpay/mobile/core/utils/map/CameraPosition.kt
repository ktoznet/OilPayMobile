package com.oilpay.mobile.core.utils.map

import com.oilpay.mobile.domain.entities.LatLng

expect class PlatformCameraPosition

expect class CameraPosition(platformCameraPosition: PlatformCameraPosition) {

    constructor(
        target: LatLng,
        zoom: Float
    )
}