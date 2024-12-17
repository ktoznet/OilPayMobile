package com.oilpay.mobile.core.di.modules.confirm

import ConfirmationComponent
import DefaultConfirmationComponent
import org.koin.dsl.module

val confirmModuleDI = module {
    factory<ConfirmationComponent.Factory> { (onConf: () -> Unit, onNavigateToBiometry: () -> Unit) ->
        ConfirmationComponent.Factory { context ->
            DefaultConfirmationComponent(
                context,
                onConfirmed = onConf,
                onNavigateToMain = onNavigateToBiometry
            )
        }
    }
}