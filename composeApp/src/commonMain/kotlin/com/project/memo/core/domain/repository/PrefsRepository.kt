package com.project.memo.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface PrefsRepository {
    suspend fun getDarkThemePrefs(): Flow<Boolean>
    suspend fun setDarkThemePrefs(darkTheme: Boolean)
}