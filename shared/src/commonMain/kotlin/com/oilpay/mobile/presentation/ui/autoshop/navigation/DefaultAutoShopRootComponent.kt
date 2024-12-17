package com.oilpay.mobile.presentation.ui.autoshop.navigation

import MainScreenComponent
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.pushNew
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
import com.oilpay.mobile.core.ext.stackComponentEvents
import com.oilpay.mobile.core.events.EventsProducerDelegate
import com.oilpay.mobile.core.events.EventsProducerDelegateImpl
import com.oilpay.mobile.presentation.ui.autoshop.categories.component.AutoShopCategoriesComponent
import io.github.aakira.napier.Napier
import io.ktor.client.plugins.logging.Logging
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf


internal class DefaultAutoShopRootComponent(
    componentContext: AppComponentContext,
):
    AutoShopRootComponent,
    AutoShopRootScreenComponent,
    EventsProducerDelegate<AutoShopRootScreenComponent.Event> by EventsProducerDelegateImpl(),
    BaseComponent(componentContext)
{
    private val autoShopComponent: AutoShopCategoriesComponent.Factory by inject(){
        parametersOf(
            { navigateToMain() }
        )
    }

    private val mainComponent: MainScreenComponent.Factory by inject(){
        parametersOf(
            {}
        )
    }

    private val coroutineScope = coroutineScope()

    override val content: ComponentContent =  AutoShopRootScreen(this)

    private val navigation = StackNavigation<Config>()

    private val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.AutoShopCategories,
        handleBackButton = true,
        key = KEY,
        childFactory = ::processChild
    )
    override val childStack: Value<ChildStack<*, DecomposeComponent>> = stack

    init {
        stack
            .stackComponentEvents<AutoShopCategoriesComponent.Event>()
            .onEach {
                when (it) {
                    is AutoShopCategoriesComponent.Event.NavigateTo -> {
                        TODO("реализовать переход дальше")
                    }

                    else -> {
                        TODO("else")
                    }
                }
            }
            .launchIn(coroutineScope)
    }


    private fun processChild(
        config: Config,
        componentContext: AppComponentContext
    ) : DecomposeComponent {
        return when(config) {
            is Config.AutoShopCategories -> autoShopComponent.create(componentContext)

            is Config.MainFlow -> mainComponent.create(componentContext)
        }
    }

    private fun navigateToMain() {
        dispatch(AutoShopRootScreenComponent.Event.NavigateBack)
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object AutoShopCategories: Config

        @Serializable
        data object MainFlow: Config

    }

    companion object {
        private const val KEY = " AutoShopRootStack"
    }
}