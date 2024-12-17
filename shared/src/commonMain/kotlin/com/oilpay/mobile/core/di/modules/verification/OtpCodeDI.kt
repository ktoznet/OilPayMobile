package com.oilpay.mobile.core.di.modules.verification

import com.oilpay.mobile.presentation.ui.verification.component.otp.DefaultOtpCodeComponent
import com.oilpay.mobile.presentation.ui.verification.component.otp.OtpCodeScreenComponent
import org.koin.dsl.module

val otpCodeModuleDI = module {

    factory<OtpCodeScreenComponent.Factory> { (onNavIden: () -> Unit) ->
        OtpCodeScreenComponent.Factory { context, phone ->
            DefaultOtpCodeComponent(
                context,
                phone,
                confirmCodeUseCase = get(),
                onNavigateToIdentify = onNavIden
            )
        }
    }
}