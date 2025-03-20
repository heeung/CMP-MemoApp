package com.project.memo.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

val LightColorPalette = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC5),
    background = Color.White,
)

val DarkColorPalette = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC5),
    background = Color.Black,
)

val LocalTheme = compositionLocalOf { lightColors() }

@Composable
fun CustomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    customTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        customTheme -> if (darkTheme) DarkColorPalette else LightColorPalette
        else -> if (darkTheme) DarkColorPalette else LightColorPalette
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}