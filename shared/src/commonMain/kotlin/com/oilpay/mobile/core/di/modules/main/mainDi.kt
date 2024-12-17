package com.oilpay.mobile.core.di.modules.main

import MainScreenComponent
import com.oilpay.mobile.presentation.ui.main.main.component.DefaultMainScreenComponent
import org.koin.dsl.module

val mainModuleDI = module {

    factory<MainScreenComponent.Factory> { (onNavigateToAutoShop: () -> Unit )->
        MainScreenComponent.Factory { context ->
            DefaultMainScreenComponent(
                context,
                {},
                {},
                {},
                {},
                {},
                {onNavigateToAutoShop()}
            )
        }
    }
}