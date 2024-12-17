package com.oilpay.mobile.data.local.datasource

import AppDispatchers
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.oilpay.mobile.data.local.api.OnBoardingStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

internal class OnBoardingStorageImpl(
    private val scope: CoroutineScope,
    private val dataStore: DataStore<Preferences>
): OnBoardingStorage {


    companion object {
        private val ON_BOARDING_VIEWED_KEY = booleanPreferencesKey("on_boarding_viewed")
    }

    override suspend fun onBoardingStatus(): Boolean  {
        return dataStore.data.first()[ON_BOARDING_VIEWED_KEY] ?: false
    }

    override fun setOnBoardingStatus(isViewed: Boolean) {
        scope.launch(AppDispatchers.io) {
            println("status changed to $isViewed")
            dataStore.edit { preferences ->
                preferences[ON_BOARDING_VIEWED_KEY] = isViewed
            }
        }
    }

}