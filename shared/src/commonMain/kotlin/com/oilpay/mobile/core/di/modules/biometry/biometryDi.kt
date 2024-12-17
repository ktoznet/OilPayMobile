package com.oilpay.mobile.core.di.modules.biometry

import BiometryComponent
import DefaultBiometryComponent
import org.koin.dsl.module

val biometryModuleDI = module {
    factory<BiometryComponent.Factory>{(onConfirmationRequest: () -> Unit,onNavIden: () -> Unit) ->
        BiometryComponent.Factory{context ->
            DefaultBiometryComponent(
                context,
                onConfirmationRequest,
                onNavIden
            )
        }
    }
}

