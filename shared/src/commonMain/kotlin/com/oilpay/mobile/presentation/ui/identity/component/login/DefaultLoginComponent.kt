package com.oilpay.mobile.presentation.ui.identity.component.login

import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.oilpay.mobile.presentation.ui.identity.ui.login.LoginScreen
import com.oilpay.mobile.presentation.mvi.MviComponent

import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.events.EventsProducerDelegate
import com.oilpay.mobile.core.events.EventsProducerDelegateImpl

internal class DefaultLoginComponent(
    context: AppComponentContext
): MviComponent<LoginState, LoginAction, LoginSideEffect, LoginStore>,
    LoginComponent,
    EventsProducerDelegate<LoginComponent.Event> by EventsProducerDelegateImpl(),
    AppComponentContext by context {

    override val content: ComponentContent = LoginScreen(this)

    override val store: LoginStore = instanceKeeper.getOrCreate { LoginStore() }

    override fun dispatchAction(action: LoginAction) {
        when(action) {
            LoginAction.ClickLogin -> clickLogin()
            is LoginAction.InputPhone -> blockingIntent {
                reduce { state.copy(phone = action.phone) }
            }

            is LoginAction.ClickCheckbox -> blockingIntent {
                reduce { state.copy(checked = action.checked) }
            }
        }
    }

    private fun clickLogin() = intent {
        var phone = state.phone
        if (phone.isNotEmpty()) {

            phone = REGIONAL_CODE + phone

            store.launchOperation(
                operation = { store.sendAuthCode(phone = phone) },
                loading = { reduce { state.copy(isLoading = it) } },
                success = {
                    dispatch(LoginComponent.Event.NavigateToOtp(phone = phone))
                },
                failure = {

                }
            )
        } else {
            dispatch(LoginComponent.Event.ShowError("Phone number cannot be empty"))
        }
    }
    companion object {
        private const val REGIONAL_CODE = "+998"
    }
}