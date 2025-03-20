package com.project.memo.settings.presentation.intent

sealed interface SettingEvent {
    data object OnClickThemeChangeButton: SettingEvent
}