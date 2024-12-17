package com.oilpay.mobile.presentation.mvi

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.annotation.OrbitDsl
import org.orbitmvi.orbit.annotation.OrbitInternal
import org.orbitmvi.orbit.syntax.IntentContext
import org.orbitmvi.orbit.syntax.Syntax


interface MviComponent<STATE: Any, ACTION: Any, SIDE_EFFECT: Any, STORE> where STORE: MviStore<STATE, ACTION, SIDE_EFFECT> {

    private val ioScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.IO + SupervisorJob())

    val store: STORE
    fun dispatchAction(action: ACTION)

    @OrbitDsl
    fun intent(
        registerIdling: Boolean = true,
        transformer: suspend Syntax<STATE, SIDE_EFFECT>.() -> Unit
    ) = store.intent(registerIdling) { transformer() }

    @OrbitDsl
    fun blockingIntent(
        registerIdling: Boolean = true,
        transformer: suspend Syntax<STATE, SIDE_EFFECT>.() -> Unit
    ) = store.blockingIntent(registerIdling) { transformer() }

    @OptIn(OrbitInternal::class)
    fun <S : Any, SE : Any> Syntax<S, SE>.reduceLocal(reducer: IntentContext<S>.() -> S) {
        ioScope.launch {
            containerContext.reduce { reducerState ->
                IntentContext(reducerState).reducer()
            }
        }
    }
}