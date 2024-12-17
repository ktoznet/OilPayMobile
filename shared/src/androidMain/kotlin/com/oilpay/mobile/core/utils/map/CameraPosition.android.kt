package com.oilpay.mobile.core.utils.map

import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.ktx.model.cameraPosition
import com.oilpay.mobile.domain.entities.LatLng

actual typealias PlatformCameraPosition = CameraPosition

actual class CameraPosition actual constructor(
    val platformCameraPosition: PlatformCameraPosition
) {
    actual constructor(
        target: LatLng,
        zoom: Float
    ) : this(
        platformCameraPosition = cameraPosition {
            target(target.platform)
            zoom(zoom)
        }
    )
}
