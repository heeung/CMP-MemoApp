package com.project.memo.home.presentation.intent

sealed interface HomeEvent {
    data object OnClickToggleButton: HomeEvent
}