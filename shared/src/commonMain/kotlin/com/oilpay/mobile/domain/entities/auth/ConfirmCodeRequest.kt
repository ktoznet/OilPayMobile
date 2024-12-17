package com.oilpay.mobile.domain.entities.auth

@kotlinx.serialization.Serializable
data class ConfirmCodeRequest(
    val phone: String,
    val code: Int
)
