package com.oilpay.mobile.presentation.ui.main.history

data class HistoryElement(
    val id: String,
    val gasName: String,
    val location: String,
    val pump: Int,
    val fuelType: String,
    val fuelAmount: Int,
    val date: String,
    val price: String
)

