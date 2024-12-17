package com.oilpay.mobile.presentation.navigation.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.oilpay.mobile.presentation.ui.splash.component.SplashComponent
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.serialization.Serializable
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import com.oilpay.mobile.core.context.wrapComponentContext
import com.oilpay.mobile.core.di.setup.Injector
import com.oilpay.mobile.core.ext.stackComponentEvents
import com.oilpay.mobile.presentation.ui.identity.component.auth.AuthRootScreenComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.getScopeId

internal class DefaultRootComponent(
    componentContext: ComponentContext
): RootComponent, ComponentContext by componentContext, KoinComponent {

    private val navigation = StackNavigation<Config>()

    private val authRootFactory by Injector.lazy<AuthRootScreenComponent.Factory>()
    private val splashFactory by Injector.lazy<SplashComponent.Factory>()





    private val coroutineScope = coroutineScope()

    private val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Splash,
        handleBackButton = true,
        key = KEY,
        childFactory = ::processChild
    )

    init {

        stack
            .stackComponentEvents<SplashComponent.Event>()
            .filterIsInstance<SplashComponent.Event>()
            .onEach {
                when(it) {
                    SplashComponent.Event.NavigateToAuth -> navigateToAuth()
                }
            }
            .launchIn(coroutineScope)

    }

    override val childStack: Value<ChildStack<*, DecomposeComponent>> = stack

    private fun processChild(
        config: Config,
        componentContext: ComponentContext
    ): DecomposeComponent {
        val context = wrapComponentContext(
            context = componentContext,
            parentScopeID = getKoin().getScopeId()
        )
        return when(config) {

            Config.LoginFlow -> authRootFactory.create(
                context = context
            )

            Config.Splash -> splashFactory.create(
                context = context
            )

        }
    }

    private fun navigateToAuth() {
        navigation.replaceCurrent(Config.LoginFlow)
    }


    @Serializable
    private sealed interface Config {

        @Serializable
        data object Splash: Config

        @Serializable
        data object LoginFlow : Config

    }

    companion object {
        private const val KEY = "RootStack"
    }
}