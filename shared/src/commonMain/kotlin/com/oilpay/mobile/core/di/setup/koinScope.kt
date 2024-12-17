package com.oilpay.mobile.core.di.setup


import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import org.koin.core.scope.Scope
import org.koin.core.scope.ScopeCallback
import org.koin.core.scope.ScopeID
import org.koin.mp.KoinPlatform

fun koinScope(
    vararg modules: Module,
    scopeID: ScopeID,
    qualifier: Qualifier,
) : Scope {
    val scope = KoinPlatform.getKoin().createScope(
        scopeId = scopeID,
        qualifier = qualifier,
        source = null,
    )

    val modulesList = modules.toList()

//    parentScopeID
//        ?.let(scope::getScope)
//        ?.let { parentScope ->
//            scope.linkTo(parentScope)
//        }

    KoinPlatform.getKoin().loadModules(
        modulesList,
    )

    scope.registerCallback(
        object : ScopeCallback {
            override fun onScopeClose(scope: Scope) {
                KoinPlatform.getKoin().unloadModules(
                    modulesList
                )
            }
        }
    )

//    lifecycle.doOnDestroy {
//        scope.close()
//    }

    return scope
}