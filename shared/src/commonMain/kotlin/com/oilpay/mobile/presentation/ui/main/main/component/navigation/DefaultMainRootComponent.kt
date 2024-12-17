package com.oilpay.mobile.presentation.ui.main.main.component.navigation

import MainScreenComponent
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
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
import com.oilpay.mobile.presentation.ui.autoshop.navigation.AutoShopRootComponent
import com.oilpay.mobile.presentation.ui.autoshop.navigation.AutoShopRootScreenComponent
import com.oilpay.mobile.presentation.ui.verification.component.otp.OtpCodeScreenComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf


internal class DefaultMainRootComponent(
    componentContext: AppComponentContext,
):
    MainRootComponent,
    MainRootScreenComponent,
    EventsProducerDelegate<MainRootScreenComponent.Event> by EventsProducerDelegateImpl(),
    BaseComponent(componentContext)
{
    private val mainComponent: MainScreenComponent.Factory by inject(){
        parametersOf(
            {navigateToAutoShop()}
        )
    }
    private val autoShopRootFactory: AutoShopRootScreenComponent.Factory by inject(){
        parametersOf(
            {
            }
        )
    }



    private val coroutineScope = coroutineScope()

    override val content: ComponentContent = MainRootScreen(this)

    private val navigation = StackNavigation<Config>()

    private val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Main,
        handleBackButton = true,
        key = KEY,
        childFactory = ::processChild
    )

    init {
        stack
            .stackComponentEvents<MainScreenComponent.Event>()
            .onEach {
                when (it) {
                    is MainScreenComponent.Event.NavigateTo -> {
                        navigateToAutoShop()
                    }

                    else -> {
                        TODO("else")
                    }
                }
            }
            .launchIn(coroutineScope)

        stack
            .stackComponentEvents<AutoShopRootScreenComponent.Event>()
            .onEach {
                when(it) {
                    AutoShopRootScreenComponent.Event.NavigateBack -> {
                        navigation.pop()
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

            Config.Main -> mainComponent.create(componentContext)
            Config.AutoShopFlow -> autoShopRootFactory.create(
                context = componentContext
            )
        }
    }

    private fun navigateToAutoShop() {
        navigation.pushNew(Config.AutoShopFlow)
    }

    @Serializable
    private sealed interface Config {

        @Serializable
        data object Main: Config

        @Serializable
        data object AutoShopFlow: Config

    }

    companion object {
        private const val KEY = "MainRootStack"
    }
}