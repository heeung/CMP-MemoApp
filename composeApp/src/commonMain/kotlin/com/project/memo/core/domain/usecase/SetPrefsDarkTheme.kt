package com.project.memo.core.domain.usecase

import com.project.memo.core.domain.repository.PrefsRepository

class SetPrefsDarkTheme(
    private val prefsRepository: PrefsRepository
) {
    suspend operator fun invoke(darkTheme: Boolean) {
        prefsRepository.setDarkThemePrefs(darkTheme = darkTheme)
    }
}