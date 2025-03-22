package com.project.memo.core.domain.usecase

import com.project.memo.core.domain.repository.PrefsRepository
import kotlinx.coroutines.flow.Flow

class GetPrefsDarkTheme(
    private val prefsRepository: PrefsRepository
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return prefsRepository.getDarkThemePrefs()
    }
}