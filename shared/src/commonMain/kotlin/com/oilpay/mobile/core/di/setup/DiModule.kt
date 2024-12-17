package com.oilpay.mobile.core.di.setup

import com.oilpay.mobile.core.di.modules.network.networkSetup
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    singleOf(::networkSetup)
}