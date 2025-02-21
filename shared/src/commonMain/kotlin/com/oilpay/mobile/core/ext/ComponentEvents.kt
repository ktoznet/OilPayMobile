package com.oilpay.mobile.core.ext

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import com.oilpay.mobile.core.events.EventsProducer

private class ValueStateFlow<out T : Any>(
    private val v: Value<T>,
) : StateFlow<T> {
    override val value: T get() = v.value
    override val replayCache: List<T> get() = listOf(v.value)

    override suspend fun collect(collector: FlowCollector<T>): Nothing {
        val flow = MutableStateFlow(v.value)
        val observer: (T) -> Unit = { flow.value = it }
        val cancellation = v.subscribe(observer)

        try {
            flow.collect(collector)
        } finally {
            cancellation.cancel()
        }
    }
}

fun <T : Any> Value<T>.asStateFlow(): StateFlow<T> = ValueStateFlow(this)

@OptIn(ExperimentalCoroutinesApi::class)
inline fun <reified E : Any> Value<ChildStack<*, *>>.stackComponentEvents(): Flow<E> {
    return this
        .asStateFlow()
        .map { stack -> stack.active.instance }
        .filterIsInstance<EventsProducer<E>>()
        .flatMapLatest { component -> component.events }
        .filterIsInstance<E>()
}
