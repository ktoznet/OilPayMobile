package com.oilpay.mobile.core.ext

import cocoapods.GoogleMaps.GMSMapView
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIImage

@OptIn(ExperimentalForeignApi::class)
actual typealias GoogleMap = GMSMapView

actual typealias MarkerImage = UIImage
