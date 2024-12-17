package com.oilpay.mobile.core.events

interface EventsProducerDelegate<Event : Any> : EventsProducer<Event> {
    fun dispatch(event: Event)
}