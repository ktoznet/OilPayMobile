package com.oilpay.mobile.core.context

import com.arkivanov.decompose.GenericComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent

interface AppComponentContext : GenericComponentContext<AppComponentContext>,
    ParentScopeIdOwner, DecomposeComponent