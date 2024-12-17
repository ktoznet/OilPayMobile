package com.oilpay.mobile.domain.entities

import kotlin.jvm.JvmInline

sealed interface ZoomLevelState {
    @JvmInline
    value class Moving(val zoom: Float) : ZoomLevelState

    @JvmInline
    value class Idle(val zoom: Float) : ZoomLevelState
}