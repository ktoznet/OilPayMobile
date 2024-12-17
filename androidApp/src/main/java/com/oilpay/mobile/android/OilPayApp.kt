package com.oilpay.mobile.android

import android.app.Application
import com.oilpay.mobile.core.di.setup.KoinInjector
import org.koin.android.ext.koin.androidContext

class OilPayApp: Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInjector.koinApp.androidContext(this)
    }
}