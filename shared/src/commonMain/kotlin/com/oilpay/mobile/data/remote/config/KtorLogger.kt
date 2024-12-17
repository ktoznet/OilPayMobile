package com.oilpay.mobile.data.remote.config

import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging

fun HttpClientConfig<*>.installLogger() {
    install(Logging) {
        logger = ktorLogger
        level = LogLevel.ALL
    }
}

private val ktorLogger: Logger = object : Logger {
    override fun log(message: String) {
        dLong("KTOR", message)
    }
}

private const val MAX_LENGTH = 4000

fun dLong(tag: String, message: String) {
    if (message.length <= MAX_LENGTH) {
        println("$tag $message")
    } else {
        var startIndex = 0
        var endIndex = MAX_LENGTH

        while (startIndex < message.length) {
            if (endIndex > message.length)
                endIndex = message.length

            val part = message.substring(startIndex, endIndex)
            println("$tag $part")

            startIndex = endIndex
            endIndex += MAX_LENGTH
        }
    }
}