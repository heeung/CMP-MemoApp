package com.project.memo

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.project.memo.app.App
import com.project.memo.app.rememberAppState
import com.project.memo.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "MemoApp",
        ) {
            val appState = rememberAppState()

            MaterialTheme {
                App(appState)
            }
        }
    }
}