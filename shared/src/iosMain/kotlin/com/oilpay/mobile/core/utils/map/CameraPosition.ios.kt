package com.oilpay.mobile.core.utils.map

import cocoapods.GoogleMaps.GMSCameraPosition
import com.oilpay.mobile.domain.entities.LatLng
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
actual typealias PlatformCameraPosition = GMSCameraPosition

@OptIn(ExperimentalForeignApi::class)
actual class CameraPosition actual constructor(
    val platformCameraPosition: PlatformCameraPosition
) {
    actual constructor(
        target: LatLng,
        zoom: Float
    ) : this(
        platformCameraPosition = GMSCameraPosition.cameraWithTarget(
            target = target.cValue,
            zoom = zoom
        )
    )
}
