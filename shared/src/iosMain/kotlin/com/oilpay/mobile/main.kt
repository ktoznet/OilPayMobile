package com.oilpay.mobile

import androidx.compose.ui.window.ComposeUIViewController
import com.oilpay.mobile.presentation.navigation.components.RootComponent
import com.oilpay.mobile.presentation.navigation.screen.RootScreen
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import platform.UIKit.UIViewController

fun MainViewController(rootComponent: RootComponent): UIViewController =
    ComposeUIViewController { OilPayTheme { RootScreen(rootComponent) } }
