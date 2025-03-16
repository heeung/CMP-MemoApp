package com.project.memo.home.presentation

import androidx.lifecycle.viewModelScope
import com.project.memo.core.BaseViewModel
import com.project.memo.home.presentation.intent.HomeEvent
import com.project.memo.home.presentation.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    // TODO Repository
): BaseViewModel<HomeUiState, HomeEvent>(
    initialState = HomeUiState()
) {
    private val _homeState = MutableStateFlow(HomeUiState())
    val homeState = _homeState
        .onStart {

        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = _homeState.value
        )

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnClickToggleButton -> {
                setState { copy(isOpen = !isOpen) }
            }
        }
    }
}