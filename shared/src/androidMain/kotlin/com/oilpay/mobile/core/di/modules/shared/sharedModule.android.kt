package com.oilpay.mobile.core.di.modules.shared

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.oilpay.mobile.data.local.datasource.dataStore
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val sharedModule: Module = module {
    single<DataStore<Preferences>> { get<Context>().dataStore() }
}