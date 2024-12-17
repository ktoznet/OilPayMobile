package com.oilpay.mobile.core.di.setup


import com.oilpay.mobile.core.di.modules.auth.authRootModuleDI
import com.oilpay.mobile.core.di.modules.auth.loginModuleDI
import com.oilpay.mobile.core.di.modules.auth.smsModule
import com.oilpay.mobile.core.di.modules.autoshop.categories.autoModule
import com.oilpay.mobile.core.di.modules.autoshop.categories.autoShopRootModule
import com.oilpay.mobile.core.di.modules.biometry.biometryModuleDI
import com.oilpay.mobile.core.di.modules.biometry.idenModuleDI
import com.oilpay.mobile.core.di.modules.confirm.confirmModuleDI
import com.oilpay.mobile.core.di.modules.main.mainModuleDI
import com.oilpay.mobile.core.di.modules.main.mainRootModuleDI
import com.oilpay.mobile.core.di.modules.onboarding.onBoardingModule
import com.oilpay.mobile.core.di.modules.onboarding.onBoardingModuleDI
import com.oilpay.mobile.core.di.modules.shared.sharedModule
import com.oilpay.mobile.core.di.modules.splash.splashModule
import com.oilpay.mobile.core.di.modules.splash.splashModuleDI
import com.oilpay.mobile.core.di.modules.storage.storageModule
import com.oilpay.mobile.core.di.modules.verification.otpCodeModuleDI
import com.oilpay.mobile.core.di.modules.verification.pinCodeModuleDI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

private val coroutineModule = module {
    single { CoroutineScope(SupervisorJob() + Dispatchers.Main) }
}

object KoinInjector {

    val koinApp = startKoin {
        modules(
            listOf(
                sharedModule,
                smsModule,
                storageModule,
                coroutineModule,
                networkModule,
                autoShopRootModule,
                autoModule,
                loginModuleDI,
                authRootModuleDI,
                mainRootModuleDI,
                onBoardingModuleDI,
                onBoardingModule,
                splashModuleDI,
                splashModule,
                otpCodeModuleDI,
                idenModuleDI,
                confirmModuleDI,
                biometryModuleDI,
                pinCodeModuleDI,
                mainModuleDI
            )
        )
    }

    val koin = koinApp.koin

    fun loadModules(modules: List<Module>) {
        koinApp.koin.loadModules(modules)
    }
}