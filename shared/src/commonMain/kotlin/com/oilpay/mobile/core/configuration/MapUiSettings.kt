package com.oilpay.mobile.core.configuration

internal val DefaultMapUiSettings = MapUiSettings()

data class MapUiSettings(
    val compassEnabled: Boolean = false,
    val myLocationButtonEnabled: Boolean = false
)