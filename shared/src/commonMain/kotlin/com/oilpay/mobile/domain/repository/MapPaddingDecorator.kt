package com.oilpay.mobile.domain.repository

interface MapPaddingDecorator {

    fun updateContentPadding(left: Int = 0, top: Int = 0, right: Int = 0, bottom: Int = 0)

    fun additionalPadding(left: Int = 0, top: Int = 0, right: Int = 0, bottom: Int = 0)
}
