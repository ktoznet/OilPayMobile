package com.oilpay.mobile.domain.entities.auth



@kotlinx.serialization.Serializable
data class TokenResponse(
    val refresh_token: String,
    val access_token: String,
    val token_type: String
)