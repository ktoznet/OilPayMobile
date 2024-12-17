package com.oilpay.mobile.presentation.ui.identity.component.auth

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.oilpay.mobile.presentation.ui.identity.component.login.LoginComponent
import com.oilpay.mobile.presentation.ui.identity.ui.auth.AuthRootScreen
import com.oilpay.mobile.presentation.ui.verification.component.otp.OtpCodeScreenComponent
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.serialization.Serializable
import com.oilpay.mobile.presentation.components.decompose.BaseComponent
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.core.di.setup.Injector
import com.oilpay.mobile.core.ext.stackComponentEvents
import com.oilpay.mobile.core.events.EventsProducerDelegate
import com.oilpay.mobile.core.events.EventsProducerDelegateImpl
import com.oilpay.mobile.presentation.navigation.components.RootComponent
import com.oilpay.mobile.presentation.ui.main.main.component.navigation.MainRootScreenComponent
import com.oilpay.mobile.presentation.ui.verification.component.pin.PinCodeComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf


internal class DefaultAuthRootComponent(
    componentContext: AppComponentContext,
):
    AuthRootComponent,
    AuthRootScreenComponent,
    EventsProducerDelegate<AuthRootScreenComponent.Event> by EventsProducerDelegateImpl(),
    BaseComponent(componentContext)
{
    private val mainRootFactory by Injector.lazy<MainRootScreenComponent.Factory>()
    private val authRootFactory by Injector.lazy<RootComponent>()
    private val loginComponent: LoginComponent.Factory by inject()
    private val otpCodeComponent: OtpCodeScreenComponent.Factory by inject(){
        parametersOf(
            {navigateToPinCode()}
        )
    }

    private val pinCodeFactory by Injector.lazy<PinCodeComponent.Factory>(){
        parametersOf(
            { pin: String -> navigateToPinCodeRepeat(pin) },
            { navigateToMain() }
        )
    }
    private val coroutineScope = coroutineScope()

    override val content: ComponentContent = AuthRootScreen(this)

    private val navigation = StackNavigation<Config>()

    private val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Login,
        handleBackButton = true,
        key = KEY,
        childFactory = ::processChild
    )

    init {
        stack
            .stackComponentEvents<LoginComponent.Event>()
            .onEach {
                when (it) {
                    is LoginComponent.Event.NavigateToOtp -> navigation.pushNew(
                        configuration = Config.OtpCode(it.phone)
                    )

                    is LoginComponent.Event.ShowError ->{
                        println("LoginComponent.Event.ShowError: ${it.message}")
                    }
                }
            }
            .launchIn(coroutineScope)

        stack
            .stackComponentEvents<OtpCodeScreenComponent.Event>()
            .onEach { event ->
                when (event) {
                    is OtpCodeScreenComponent.Event.NavigateToNextScreen -> {
                        navigation.replaceCurrent(Config.PinCode)
                    }
                    is OtpCodeScreenComponent.Event.ShowMessage -> {
                        println("Unexpected error: ${event.message}")
                    }
                }
            }
            .launchIn(coroutineScope)
    }

    override val childStack: Value<ChildStack<*, DecomposeComponent>> = stack

    private fun processChild(
        config: Config,
        componentContext: AppComponentContext
    ) : DecomposeComponent {
        return when(config) {
            Config.Login -> loginComponent.create(componentContext)
            is Config.OtpCode -> otpCodeComponent.create(componentContext, config.phone)
            Config.PinCode -> pinCodeFactory.create(
                context = componentContext,false
            )
            is Config.PinCodeRepeat -> pinCodeFactory.create(
                context = componentContext, true
            )
            Config.MainFlow -> mainRootFactory.create(
                context = componentContext
            )
        }
    }

    private fun navigateToPinCode(){
        navigation.replaceCurrent(Config.PinCode)
    }
    private fun navigateToPinCodeRepeat(pin: String){
        navigation.replaceCurrent(Config.PinCodeRepeat(pin))
    }

    private fun navigateToMain() {
        navigation.replaceCurrent(Config.MainFlow)
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Login : Config

        @Serializable
        data class OtpCode(val phone: String): Config

        @Serializable
        data object PinCode: Config

        @Serializable
        data class PinCodeRepeat(val pin: String): Config

        @Serializable
        data object MainFlow :Config

    }

    companion object {
        private const val KEY = "AuthRootStack"
    }
}