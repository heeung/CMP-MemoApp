package com.project.memo.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<UI_STATE, SIDE_EFFECT>(
    val scope: CoroutineScope = CoroutineScope(Dispatchers.IO),
    initialState: UI_STATE
): ViewModel() {

    var uiState = MutableStateFlow(initialState)
        private set

    private val _sideEffect: Channel<SIDE_EFFECT> = Channel(Channel.BUFFERED)
    val sideEffect = _sideEffect.receiveAsFlow()

    private val currentState: UI_STATE
        get() = uiState.value

    // state update
    protected fun setState(
        reduce: UI_STATE.() -> UI_STATE
    ) {
        uiState.update { currentState.reduce() }
    }

    protected fun postSideEffect(vararg effects: SIDE_EFFECT) {
        scope.launch {
            effects.forEach { effect ->
                _sideEffect.send(effect)
            }
        }
    }
}