package com.oilpay.mobile.core.context

import com.arkivanov.decompose.GenericComponentContext
import org.koin.core.scope.ScopeID

fun wrapComponentContext(
    context: GenericComponentContext<*>,
    parentScopeID: ScopeID?,
): AppComponentContext {
    return DefaultAppComponentContext(
        context = context,
        parentScopeID = parentScopeID,
    )
}