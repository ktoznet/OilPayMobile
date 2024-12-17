package com.oilpay.mobile.core.di.modules.auth


import com.oilpay.mobile.presentation.ui.identity.component.auth.DefaultAuthRootComponent
import com.oilpay.mobile.presentation.ui.identity.component.auth.AuthRootScreenComponent
import org.koin.dsl.module

val authRootModuleDI = module {
    single {
        AuthRootScreenComponent.Factory { context ->
            DefaultAuthRootComponent(
                componentContext = context
            )
        }
    }
}