package com.oilpay.mobile.core.di.modules.main



import com.oilpay.mobile.presentation.ui.main.main.component.navigation.DefaultMainRootComponent
import com.oilpay.mobile.presentation.ui.main.main.component.navigation.MainRootScreenComponent
import org.koin.dsl.module

val mainRootModuleDI = module {
    single {
        MainRootScreenComponent.Factory { context ->
            DefaultMainRootComponent(
                componentContext = context
            )
        }
    }
}