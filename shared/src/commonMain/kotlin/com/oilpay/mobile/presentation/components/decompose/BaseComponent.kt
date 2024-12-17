package com.oilpay.mobile.presentation.components.decompose

import com.oilpay.mobile.core.context.AppComponentContext
import org.koin.core.component.KoinComponent

abstract class BaseComponent(
    componentContext: AppComponentContext
): AppComponentContext by componentContext, KoinComponent {
}