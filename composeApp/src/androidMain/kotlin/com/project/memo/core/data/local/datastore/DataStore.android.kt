package com.project.memo.core.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.project.memo.MainActivity
import com.project.memo.MainApplication

actual object DataStore {
    actual fun create(): DataStore<Preferences> {
        return createDataStore(
            producePath = { MainApplication.appContext.filesDir.resolve(DATA_STORE_FILE_NAME).absolutePath }
        )
    }
}