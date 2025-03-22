package com.project.memo.settings.presentation

import androidx.lifecycle.viewModelScope
import com.project.memo.core.base.BaseViewModel
import com.project.memo.core.designsystem.theme.CustomColor
import com.project.memo.core.domain.usecase.GetPrefsDarkTheme
import com.project.memo.core.domain.usecase.SetPrefsDarkTheme
import com.project.memo.settings.presentation.intent.SettingEvent
import com.project.memo.settings.presentation.state.SettingUiState
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingViewModel(
    // TODO Repository
    private val getPrefsDarkTheme: GetPrefsDarkTheme,
    private val setPrefsDarkTheme: SetPrefsDarkTheme
): BaseViewModel<SettingUiState, SettingEvent>(
    initialState = SettingUiState()
) {
    private var observeDarkThemeJob: Job? = null

    private val _settingState = MutableStateFlow(SettingUiState())
    val settingState = _settingState
        .onStart {
            observeDarkTheme()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = _settingState.value
        )

    fun onEvent(event: SettingEvent) {
        when (event) {
            is SettingEvent.OnClickThemeChangeButton -> {
                setDartTheme(isDark = !settingState.value.isDark)
            }
        }
    }

    private suspend fun observeDarkTheme() {
        observeDarkThemeJob?.cancel()
        observeDarkThemeJob = getPrefsDarkTheme.invoke()
            .onEach { isDark ->
                _settingState.update { it.copy(
                    isDark = isDark
                ) }
                CustomColor.toggleTheme(isDark)
            }
            .launchIn(viewModelScope)
    }

    private fun setDartTheme(
        isDark: Boolean
    ) {
        viewModelScope.launch {
            setPrefsDarkTheme.invoke(isDark)
        }
    }

    init {
        println("darkT")
    }
}