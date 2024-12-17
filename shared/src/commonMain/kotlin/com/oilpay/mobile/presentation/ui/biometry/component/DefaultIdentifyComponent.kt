package com.oilpay.mobile.presentation.ui.biometry.component

import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.ui.biometry.IdentifyScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DefaultIdentifyComponent(
    componentContext: AppComponentContext,
    private val onInstructionsCompleted: () -> Unit
) : IdentifyComponent, AppComponentContext by componentContext {

    override val content: ComponentContent = IdentifyScreen(this)
    override fun onInstructionsFollowed() {

    }
}
