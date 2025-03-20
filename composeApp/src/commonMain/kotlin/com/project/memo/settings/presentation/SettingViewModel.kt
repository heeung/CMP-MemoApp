package com.project.memo.settings.presentation

import androidx.lifecycle.viewModelScope
import com.project.memo.core.base.BaseViewModel
import com.project.memo.settings.presentation.intent.SettingEvent
import com.project.memo.settings.presentation.state.SettingUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class SettingViewModel(
    // TODO Repository
): BaseViewModel<SettingUiState, SettingEvent>(
    initialState = SettingUiState()
) {
    private val _settingState = MutableStateFlow(SettingUiState())
    val settingState = _settingState
        .onStart {

        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = _settingState.value
        )

    fun onEvent(event: SettingEvent) {
        when (event) {
            is SettingEvent.OnClickThemeChangeButton -> {
                setState { copy(isDark = !isDark) }
            }
        }
    }
}