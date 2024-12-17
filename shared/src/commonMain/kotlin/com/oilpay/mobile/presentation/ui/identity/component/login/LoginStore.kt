package com.oilpay.mobile.presentation.ui.identity.component.login

import com.oilpay.mobile.presentation.mvi.MviStore

data class LoginState(
    val isLoading: Boolean = false,
    val phone: String = "",
    val checked: Boolean = false
)

sealed interface LoginAction {
    data object ClickLogin: LoginAction
    data class InputPhone(val phone: String): LoginAction
    data class ClickCheckbox(val checked: Boolean): LoginAction
}

sealed interface LoginSideEffect {

}

class LoginStore: MviStore<LoginState, LoginAction, LoginSideEffect>(
    state = LoginState()
),  LoginInteractor by LoginInteractorImpl()