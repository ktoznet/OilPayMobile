package com.oilpay.mobile.data.entity.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthEntityRequest(
    val phone: String
)
