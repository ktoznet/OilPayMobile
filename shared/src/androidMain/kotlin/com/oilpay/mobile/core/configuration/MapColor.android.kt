package com.oilpay.mobile.core.configuration


import com.google.android.gms.maps.model.MapColorScheme

fun MapColor.toAndroidColorScheme() = when (this) {
    MapColor.Light -> MapColorScheme.LIGHT
    MapColor.Dark -> MapColorScheme.DARK
    MapColor.System -> MapColorScheme.FOLLOW_SYSTEM
}
