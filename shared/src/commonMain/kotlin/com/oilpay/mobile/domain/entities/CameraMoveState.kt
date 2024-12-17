package com.oilpay.mobile.domain.entities

sealed interface CameraMoveState {
    data object UserGesture : CameraMoveState
    data object Animating : CameraMoveState
    data object Idle : CameraMoveState
}