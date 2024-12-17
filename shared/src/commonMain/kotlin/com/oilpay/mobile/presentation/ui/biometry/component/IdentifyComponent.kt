package com.oilpay.mobile.presentation.ui.biometry.component

import com.oilpay.mobile.core.content.ComponentContentOwner
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent

interface IdentifyComponent: DecomposeComponent, ComponentContentOwner {
    fun onInstructionsFollowed()

    fun interface Factory {
        fun create(context: AppComponentContext): IdentifyComponent
    }
}
