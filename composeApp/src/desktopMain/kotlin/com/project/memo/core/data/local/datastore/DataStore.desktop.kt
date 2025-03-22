package com.project.memo.core.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

actual object DataStore {
    actual fun create(): DataStore<Preferences> {
        return createDataStore { DATA_STORE_FILE_NAME }
    }
}