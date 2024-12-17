package com.oilpay.mobile.core.configuration

import platform.UIKit.UIUserInterfaceStyle.UIUserInterfaceStyleDark
import platform.UIKit.UIUserInterfaceStyle.UIUserInterfaceStyleLight
import platform.UIKit.UIUserInterfaceStyle.UIUserInterfaceStyleUnspecified

fun MapColor.toIosColorScheme() = when (this) {
    MapColor.Light -> UIUserInterfaceStyleLight
    MapColor.Dark -> UIUserInterfaceStyleDark
    MapColor.System -> UIUserInterfaceStyleUnspecified
}
