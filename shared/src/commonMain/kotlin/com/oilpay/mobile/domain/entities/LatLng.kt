package com.oilpay.mobile.domain.entities

expect class PlatformLatLng

expect class LatLng(platform: PlatformLatLng) {

    val latitude: Double
    val longitude: Double

    constructor(latitude: Double, longitude: Double)
}
