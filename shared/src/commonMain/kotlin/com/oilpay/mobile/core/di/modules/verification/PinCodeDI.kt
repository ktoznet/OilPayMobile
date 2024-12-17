package com.oilpay.mobile.core.di.modules.verification

import com.oilpay.mobile.presentation.ui.verification.component.pin.PinCodeComponent
import com.oilpay.mobile.presentation.ui.verification.component.pin.DefaultPinCodeComponent
import org.koin.dsl.module



val pinCodeModuleDI = module {
    factory<PinCodeComponent.Factory> { (onPinConfirmed: (String) -> Unit, onNavigateToBiometry: () -> Unit) ->
        PinCodeComponent.Factory { context, isRepeat ->
            DefaultPinCodeComponent(
                context,
                isRepeat = isRepeat,
                onPinConfirmed = onPinConfirmed,
                onNavigateToBiometry = onNavigateToBiometry
            )
        }
    }
}