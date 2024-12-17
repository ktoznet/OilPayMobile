package com.oilpay.mobile.data.mappers

import com.oilpay.mobile.data.entity.base.BaseEntityResponse
import com.oilpay.mobile.domain.entities.base.BaseEntityUIResponse

fun BaseEntityResponse.toUI() = BaseEntityUIResponse(
        message = this.message
    )