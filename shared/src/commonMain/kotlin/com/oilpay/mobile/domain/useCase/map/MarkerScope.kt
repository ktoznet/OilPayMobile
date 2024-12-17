package com.oilpay.mobile.domain.useCase.map

import com.oilpay.mobile.core.content.map.Marker

expect fun Marker?.inScope(action: Marker.() -> Unit)
