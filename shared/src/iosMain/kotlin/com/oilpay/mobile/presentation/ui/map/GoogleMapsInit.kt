package com.oilpay.mobile.presentation.ui.map

import cocoapods.GoogleMaps.GMSServices
import kotlinx.cinterop.ExperimentalForeignApi

@Suppress("unused")
object GoogleMapsInit {

    @OptIn(ExperimentalForeignApi::class)
    fun start() {
        GMSServices.provideAPIKey("AIzaSyDlplzcG_60QWxlJMwq2N4w-mXiG6rGYaU")
    }
}
