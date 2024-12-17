package com.oilpay.mobile.core.di.modules.autoshop.categories

import DefaultAutoShopCategoriesComponent
import com.oilpay.mobile.presentation.ui.autoshop.categories.component.AutoShopCategoriesComponent
import com.oilpay.mobile.presentation.ui.main.main.component.DefaultMainScreenComponent
import org.koin.dsl.module

val autoModule = module {

    factory<AutoShopCategoriesComponent.Factory> { (onNavBack: () -> Unit )->
        AutoShopCategoriesComponent.Factory { context ->
            DefaultAutoShopCategoriesComponent(
                context,
                {},
                onNavBack
            )
        }
    }
}

