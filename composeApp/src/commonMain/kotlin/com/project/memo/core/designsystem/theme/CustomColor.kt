package com.project.memo.core.designsystem.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun rememberAnimatedCustomColors(
    colors: CustomColors,
    durationMillis: Int = 400
): CustomColors {
    val animatedBackground by animateColorAsState(targetValue = colors.backgroundColor, animationSpec = tween(durationMillis))
    val animatedButton by animateColorAsState(targetValue = colors.buttonColor, animationSpec = tween(durationMillis))
    val animatedText by animateColorAsState(targetValue = colors.textColor, animationSpec = tween(durationMillis))

    val buttonHoverColor = colors.buttonHoverColor
    val buttonPressColor = colors.buttonPressColor
    val selectedBackground = colors.selectedBackground

    return CustomColors(
        transparent = colors.transparent,
        backgroundColor = animatedBackground,
        buttonColor = animatedButton,
        buttonHoverColor = buttonHoverColor,
        buttonPressColor = buttonPressColor,
        textColor = animatedText,
        selectedBackground = selectedBackground
    )
}

object DefaultColor {
    @Stable val Transparent = Color(0x00000000)

    @Stable val White = Color(0xffe8e8e8)
    @Stable val HoverWhite = Color(0xffffffff)
    @Stable val PressWhite = Color(0xffd9d9d9)

    @Stable val Black = Color(0xff282828)
    @Stable val HoverBlack = Color(0xff484848)
    @Stable val PressBlack = Color(0xff000000)
}

data class CustomColors (
    @Stable val transparent: Color,

    @Stable val backgroundColor: Color,

    @Stable val buttonColor: Color,
    @Stable val buttonHoverColor: Color,
    @Stable val buttonPressColor: Color,

    @Stable val textColor: Color,

    @Stable val selectedBackground: Color,
)

object CustomColor {
    var themeState = MutableStateFlow(true)
        private set

    private val currentState: Boolean
        get() = themeState.value

    fun toggleTheme() {
        themeState.value = !currentState
    }

    val current: CustomColors
    @Composable @ReadOnlyComposable get() = LocalTheme.current
}

fun lightColors(): CustomColors = CustomColors(
    transparent = DefaultColor.Transparent,

    backgroundColor = DefaultColor.White,

    buttonColor = DefaultColor.Black,
    buttonHoverColor = DefaultColor.HoverBlack,
    buttonPressColor = DefaultColor.PressBlack,

    textColor = DefaultColor.White,

    selectedBackground = Color(0xff97f2ff),
)

fun darkColors(): CustomColors = CustomColors(
    transparent = DefaultColor.Transparent,

    backgroundColor = DefaultColor.Black,

    buttonColor = DefaultColor.White,
    buttonHoverColor = DefaultColor.HoverWhite,
    buttonPressColor = DefaultColor.PressWhite,

    textColor = DefaultColor.Black,

    selectedBackground = Color(0xff36595e),
)