package com.project.memo

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.project.memo.app.App
import com.project.memo.app.rememberAppState
import com.project.memo.core.data.local.datastore.DATA_STORE_FILE_NAME
import com.project.memo.core.data.local.datastore.createDataStore
import com.project.memo.core.designsystem.theme.CustomColor
import com.project.memo.core.designsystem.theme.CustomColors
import com.project.memo.core.designsystem.theme.CustomTheme
import com.project.memo.core.designsystem.theme.LocalTheme
import com.project.memo.core.designsystem.theme.NanumRound
import com.project.memo.core.designsystem.theme.darkColors
import com.project.memo.core.designsystem.theme.lightColors
import com.project.memo.core.designsystem.theme.rememberAnimatedCustomColors
import com.project.memo.di.initKoin

fun main() {
    initKoin()
    val prefs = createDataStore { DATA_STORE_FILE_NAME }
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "MemoApp",
            state = WindowState(
                width = 360.dp,
                height = 780.dp
            )
        ) {
            NanumRound.initFont()

            val appState = rememberAppState()

            val darkTheme = CustomColor.themeState.collectAsState()
            val colors: CustomColors = rememberAnimatedCustomColors(
                colors = when {
                    darkTheme.value -> darkColors()
                    else -> lightColors()
                }
            )

            CompositionLocalProvider(LocalTheme provides colors) {
                CustomTheme {
                    App(
                        appState = appState,
                        modifier = Modifier
                            .background(CustomColor.current.backgroundColor)
                    )
                }
            }
        }
    }
}