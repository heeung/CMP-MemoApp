package com.project.memo.core.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.project.memo.core.domain.repository.PrefsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PrefsRepositoryImpl(
    private val dataStore: DataStore<Preferences>
): PrefsRepository {
    override suspend fun getDarkThemePrefs(): Flow<Boolean> {
        return dataStore.data.map {
            val darkThemeKey = booleanPreferencesKey("darkTheme")
            it[darkThemeKey] ?: false
        }
    }

    override suspend fun setDarkThemePrefs(darkTheme: Boolean) {
        dataStore.edit {
            val darkThemeKey = booleanPreferencesKey("darkTheme")
            it[darkThemeKey] = darkTheme
        }
    }
}