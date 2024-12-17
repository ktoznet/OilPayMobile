package com.oilpay.mobile.presentation.ui.autoshop.detail

data class AutoShopManufacturerDetail(
    val id: Int,
    val image: String,
    val title: String,
    val discount: String? = null,
    val price: String,
)
