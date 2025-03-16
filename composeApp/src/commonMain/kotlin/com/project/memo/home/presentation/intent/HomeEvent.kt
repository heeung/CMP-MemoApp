package com.project.memo.home.presentation.intent

import com.project.memo.home.presentation.state.HomeUiState

sealed interface HomeEvent {
    data object OnClickToggleButton: HomeEvent
}