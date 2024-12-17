package com.oilpay.mobile.core.di.modules.auth

import com.oilpay.mobile.presentation.ui.identity.component.login.DefaultLoginComponent
import com.oilpay.mobile.presentation.ui.identity.component.login.LoginComponent
import org.koin.dsl.module

val loginModuleDI = module {
    single {
        LoginComponent.Factory { context ->
            DefaultLoginComponent(
                context = context
            )
        }
    }
}