package com.oilpay.mobile.core.di.modules.storage

import com.oilpay.mobile.data.local.api.AuthStorage
import com.oilpay.mobile.data.local.api.OnBoardingStorage
import com.oilpay.mobile.data.local.datasource.AuthStorageImpl
import com.oilpay.mobile.data.local.datasource.OnBoardingStorageImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val storageModule = module {
    singleOf(::AuthStorageImpl) {
        bind<AuthStorage>()
        createdAtStart()
    }

    singleOf(::OnBoardingStorageImpl) {
        bind<OnBoardingStorage>()
    }
}