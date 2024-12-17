package com.oilpay.mobile.core.di.modules.biometry


import com.oilpay.mobile.presentation.ui.biometry.component.DefaultIdentifyComponent
import com.oilpay.mobile.presentation.ui.biometry.component.IdentifyComponent
import org.koin.dsl.module

val idenModuleDI = module {

    single {
        IdentifyComponent.Factory { context ->
            DefaultIdentifyComponent(context, {})
        }
    }
}