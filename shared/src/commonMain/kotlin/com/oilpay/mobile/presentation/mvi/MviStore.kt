package com.oilpay.mobile.presentation.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.oilpay.mobile.core.utils.Either
import com.oilpay.mobile.core.utils.Failure
import org.koin.core.component.KoinComponent
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class MviStore<STATE: Any, ACTION: Any, SIDE_EFFECT: Any>(
    state: STATE
): InstanceKeeper.Instance, ViewModel(), ContainerHost<STATE, SIDE_EFFECT>, KoinComponent {

    private val defaultModelScope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    override val container: Container<STATE, SIDE_EFFECT> = viewModelScope.container(initialState = state)

    open fun launch(
        ceh: CoroutineExceptionHandler = CoroutineExceptionHandler {_, _ ->},
        coroutineContext: CoroutineContext = EmptyCoroutineContext,
        operation: suspend (CoroutineScope) -> Unit
    ): Job {
        return viewModelScope.launch(ceh + coroutineContext) { operation.invoke(this) }
    }

    open fun <T> launchOperation(
        operation: suspend (CoroutineScope) -> Either<Failure, T>,
        loading: suspend (Boolean) -> Unit = { setStatus(it) },
        failure: (Failure) -> Unit = { handleError(it) },
        success: (T) -> Unit = {},
    ): Job {
        return viewModelScope.launch(handler) {
            loading.invoke(true)
            withContext(defaultModelScope.coroutineContext) {
                operation(this)
            }.fold(failure, success)
            loading.invoke(false)
        }
    }

    protected val handler = CoroutineExceptionHandler { _, exception ->
        println(exception)
        if (exception.message?.contains(
                "HttpClientCall",
                true
            ) == true
        ) return@CoroutineExceptionHandler
        if (exception.message?.contains("host", true) == true) {
            handleError(Failure.InternetConnection)
        } else if (exception.message?.contains("Вы не авторизованы", true) == true) {
            handleError(Failure.NotAuth)
        } else {
            handleError(exception)
        }
    }

    protected fun handleError(failure: Throwable) {
        println(failure)
        val message = failure.message ?: "Неизвестна ошибка"
        if (message.contains("Вы не авторизованы", true)) {
            setError(Failure.NotAuth)
        } else if (!message.contains("Parent job is Completed", false)) setError(message)
    }


    /**
     * Ошибки наследованные от Failure
     */
    private val _error = Channel<Failure?>(Channel.BUFFERED)
    val error = _error.receiveAsFlow().filterNotNull()


    /**
     * Статус загрузки(launchOperation переключает)
     */
    private val _status = MutableStateFlow(false)
    val status = _status


    protected fun setStatus(status: Boolean) {
        viewModelScope.launch {
            _status.emit(status)
        }

    }

    /**
     * Показать ошибку
     */
    protected fun setError(error: String) {
        viewModelScope.launch {
            _status.emit(false)
            _error.send(Failure.Message(error))
            delay(100)
            _error.send(null)
        }
    }

    private fun setError(failure: Failure) {
        viewModelScope.launch {
            _status.emit(false)
            _error.send(failure)
            delay(100)
            _error.send(null)
        }
    }

    override fun onDestroy() {
        onCleared()
    }
}