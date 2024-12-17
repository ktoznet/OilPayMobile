package com.oilpay.mobile.data.local.api

interface OnBoardingStorage {
    suspend fun onBoardingStatus(): Boolean
    fun setOnBoardingStatus(isViewed: Boolean = true)
}