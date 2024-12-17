package com.oilpay.mobile.presentation.ui.autoshop.navigation

import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.core.content.ComponentContentOwner
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.events.EventsProducer

interface AutoShopRootScreenComponent :
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<AutoShopRootScreenComponent.Event> {

    fun interface Factory {
        fun create(
            context: AppComponentContext,
        ): AutoShopRootScreenComponent
    }

    sealed class Event {
        data object NavigateBack: Event()
    }
}