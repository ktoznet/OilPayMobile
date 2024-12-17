package com.oilpay.mobile.core.context

import org.koin.core.scope.ScopeID

interface ParentScopeIdOwner {

    val parentScopeID: ScopeID?
}