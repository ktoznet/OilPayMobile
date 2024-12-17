package com.oilpay.mobile.presentation.ui.verification.component.otp

import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.oilpay.mobile.presentation.ui.verification.ui.otp.OtpCodeScreen
import kotlinx.coroutines.delay
import com.oilpay.mobile.presentation.mvi.MviComponent
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.events.EventsProducerDelegate
import com.oilpay.mobile.core.events.EventsProducerDelegateImpl
import com.oilpay.mobile.domain.entities.auth.ApiResult
import com.oilpay.mobile.domain.useCase.auth.ConfirmCodeUseCase

class DefaultOtpCodeComponent(
    context: AppComponentContext,
    private val phone: String,
    private val confirmCodeUseCase: ConfirmCodeUseCase,
    private  val onNavigateToIdentify: () -> Unit
): MviComponent<OtpCodeState, OtpCodeAction, OtpCodeSideEffect, OtpCodeStore>,
    OtpCodeScreenComponent,
    EventsProducerDelegate<OtpCodeScreenComponent.Event> by EventsProducerDelegateImpl(),
    AppComponentContext by context {

    override val content: ComponentContent = OtpCodeScreen(this)

    override val store: OtpCodeStore = instanceKeeper.getOrCreate { OtpCodeStore() }

    override fun dispatchAction(action: OtpCodeAction) {
        when (action) {
            OtpCodeAction.ClickConfirm -> validateCode()
            is OtpCodeAction.InputCode -> editCode(action.otp)
            OtpCodeAction.CallOperator -> callOperator()
            OtpCodeAction.ResendCode -> resendCode()
        }
    }

    init {
        insertPhone()
        launchTimer()
    }

    private fun callOperator() {

    }

    private fun resendCode() {

    }

    private fun editCode(code: String) = blockingIntent {
        reduce { state.copy(otp = code) }
    }

    private fun insertPhone() = blockingIntent {
        reduce { state.copy(phone = phone) }
    }

    private fun launchTimer() = store.launch {
        intent {
            reduce { state.copy(timer = 60) }
            repeat(state.timer) {
                delay(1000)
                reduce {
                    state.copy(
                        timer = state.timer - 1,
                        isTimerEnd = state.timer == 1
                    )
                }
            }
        }

    }

    private fun validateCode() = intent {
        println("validateCode invoked")

        reduce {
            println("State before validation: $state")
            state.copy(isLoading = true)
        }

        val result = runCatching {
            confirmCodeUseCase(state.phone, state.otp.toIntOrNull() ?: 0)
        }

        result.onSuccess { apiResult ->
            println("Result success: $apiResult")
            when (apiResult) {
                is ApiResult.Success -> {
                    reduce { state.copy(isLoading = false) }
                    onNavigateToIdentify()
                }
                is ApiResult.Error -> {
                    reduce { state.copy(isLoading = false) }
                    dispatch(OtpCodeScreenComponent.Event.ShowMessage("Unexpected error: ${apiResult.exception.message}"))
                }
            }
        }.onFailure { exception ->
            println("Result failure: ${exception.message}")
            reduce { state.copy(isLoading = false) }
            dispatch(OtpCodeScreenComponent.Event.ShowMessage("Unexpected error: ${exception.message}"))
        }
        println("validateCode completed")
    }
}