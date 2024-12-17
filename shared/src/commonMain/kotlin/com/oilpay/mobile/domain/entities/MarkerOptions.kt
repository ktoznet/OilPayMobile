package com.oilpay.mobile.domain.entities

import com.oilpay.mobile.core.ext.MarkerImage


data class MarkerOptions(
    val position: LatLng,
    val icon: MarkerImage? = null,
    val zIndex: Float = 0f,
    val anchor: Anchor? = null,
    val rotation: Float? = null,
    val title: String? = null
)

data class Anchor(
    val u: Float,
    val v: Float
)
