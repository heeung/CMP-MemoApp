package com.project.memo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.project.memo.app.App
import com.project.memo.app.rememberAppState
import com.project.memo.core.designsystem.theme.CustomColor
import com.project.memo.core.designsystem.theme.CustomColors
import com.project.memo.core.designsystem.theme.CustomTheme
import com.project.memo.core.designsystem.theme.LocalTheme
import com.project.memo.core.designsystem.theme.NanumRound
import com.project.memo.core.designsystem.theme.darkColors
import com.project.memo.core.designsystem.theme.lightColors
import com.project.memo.core.designsystem.theme.rememberAnimatedCustomColors
import com.project.memo.di.initKoin
import org.koin.android.ext.koin.androidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initKoin {
            androidContext(this@MainActivity)
        }

        setContent {
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