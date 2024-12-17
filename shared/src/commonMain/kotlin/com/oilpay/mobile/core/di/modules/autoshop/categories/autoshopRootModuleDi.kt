package com.oilpay.mobile.core.di.modules.autoshop.categories



import com.oilpay.mobile.presentation.ui.autoshop.navigation.AutoShopRootScreenComponent
import com.oilpay.mobile.presentation.ui.autoshop.navigation.DefaultAutoShopRootComponent
import com.oilpay.mobile.presentation.ui.main.main.component.navigation.DefaultMainRootComponent
import com.oilpay.mobile.presentation.ui.main.main.component.navigation.MainRootScreenComponent
import org.koin.dsl.module

val autoShopRootModule = module {
    single {
        AutoShopRootScreenComponent.Factory { context ->
            DefaultAutoShopRootComponent(
                componentContext = context
            )
        }
    }
}