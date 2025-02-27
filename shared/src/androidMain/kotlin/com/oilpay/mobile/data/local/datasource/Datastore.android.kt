package com.oilpay.mobile.data.local.datasource

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.Preferences

fun Context.dataStore(): DataStore<Preferences> = createDataStore(
    producePath = {
        dataStoreFile(dataStoreFileName).absolutePath
    }
)