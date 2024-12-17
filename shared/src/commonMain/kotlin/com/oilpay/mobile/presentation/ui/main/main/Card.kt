package com.oilpay.mobile.presentation.ui.main.main

import kotlinx.serialization.Serializable

@Serializable
data class Card(
    val id: Int,
    val cardNumber: String,
    val paymentSystem: CardPaymentSystem,
    val bankInfo: CardBankInfo,
    val balance: String // ?
)
@Serializable
data class CardPaymentSystem(
    val id: Int,
    val icon: String,
    val name: String
)
@Serializable
data class CardBankInfo(
    val id: Int,
    val icon: String,
    val name: String
)