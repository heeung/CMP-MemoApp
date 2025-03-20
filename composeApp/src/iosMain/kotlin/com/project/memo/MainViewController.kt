package com.project.memo

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.project.memo.app.App
import com.project.memo.app.rememberAppState
import com.project.memo.core.designsystem.theme.CustomColor
import com.project.memo.core.designsystem.theme.CustomColors
import com.project.memo.core.designsystem.theme.CustomTheme
import com.project.memo.core.designsystem.theme.LocalTheme
import com.project.memo.core.designsystem.theme.darkColors
import com.project.memo.core.designsystem.theme.lightColors
import com.project.memo.core.designsystem.theme.rememberAnimatedCustomColors
import com.project.memo.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
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