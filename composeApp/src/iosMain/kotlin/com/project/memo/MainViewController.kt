package com.project.memo

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.window.ComposeUIViewController
import com.project.memo.app.App
import com.project.memo.app.rememberAppState
import com.project.memo.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    val appState = rememberAppState()

    MaterialTheme {
        App(appState)
    }
}