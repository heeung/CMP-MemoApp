package com.project.memo.core.designsystem.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import com.project.memo.core.domain.usecase.GetPrefsDarkTheme
import kotlinx.coroutines.flow.MutableStateFlow

object DefaultColor {
    @Stable val Transparent = Color(0x00000000)

    @Stable val White = Color(0xffe8e8e8)
    @Stable val HoverWhite = Color(0xffffffff)
    @Stable val PressWhite = Color(0xffd9d9d9)

    @Stable val Black = Color(0xff282828)
    @Stable val HoverBlack = Color(0xff484848)
    @Stable val PressBlack = Color(0xff000000)

    @Stable val Blue = Color(0xFF287EFF)
    @Stable val HoverBlue = Color(0xFF4F95FF)
    @Stable val PressBlue = Color(0xFF0066FF)

    @Stable val Gray = Color(0xFFC0C0C0)
    @Stable val HoverGray = Color(0xFFCACACA)
    @Stable val PressGray = Color(0xFFA0A0A0)
}

data class CustomColors (
    @Stable val transparent: Color,

    @Stable val backgroundColor: Color,

    @Stable val buttonColor: Color,
    @Stable val buttonHoverColor: Color,
    @Stable val buttonPressColor: Color,

    @Stable val textColor: Color,
    @Stable val buttonTextColor: Color,

    @Stable val unselectIconColor: Color,
    @Stable val selectedIconColor: Color,
)

fun lightColors(): CustomColors = CustomColors(
    transparent = DefaultColor.Transparent,

    backgroundColor = DefaultColor.White,

    buttonColor = DefaultColor.Blue,
    buttonHoverColor = DefaultColor.HoverBlue,
    buttonPressColor = DefaultColor.PressBlue,

    textColor = DefaultColor.Black,
    buttonTextColor = DefaultColor.White,

    unselectIconColor = DefaultColor.Gray,
    selectedIconColor = DefaultColor.Blue,
)

fun darkColors(): CustomColors = CustomColors(
    transparent = DefaultColor.Transparent,

    backgroundColor = DefaultColor.Black,

    buttonColor = DefaultColor.Blue,
    buttonHoverColor = DefaultColor.HoverBlue,
    buttonPressColor = DefaultColor.PressBlue,

    textColor = DefaultColor.White,
    buttonTextColor = DefaultColor.White,

    unselectIconColor = DefaultColor.Gray,
    selectedIconColor = DefaultColor.Blue,
)

@Composable
fun rememberAnimatedCustomColors(
    colors: CustomColors,
    durationMillis: Int = 400
): CustomColors {
    val animatedBackground by animateColorAsState(targetValue = colors.backgroundColor, animationSpec = tween(durationMillis))
    val animatedButton by animateColorAsState(targetValue = colors.buttonColor, animationSpec = tween(durationMillis))
    val animatedText by animateColorAsState(targetValue = colors.textColor, animationSpec = tween(durationMillis))

    val animatedUnselectIconColor by animateColorAsState(targetValue = colors.unselectIconColor, animationSpec = tween(durationMillis))
    val animatedSelectedIconColor by animateColorAsState(targetValue = colors.selectedIconColor, animationSpec = tween(durationMillis))

    return CustomColors(
        transparent = colors.transparent,
        backgroundColor = animatedBackground,

        buttonColor = animatedButton,
        buttonHoverColor = colors.buttonHoverColor,
        buttonPressColor = colors.buttonPressColor,

        textColor = animatedText,
        buttonTextColor = colors.buttonTextColor,

        unselectIconColor = animatedUnselectIconColor,
        selectedIconColor = animatedSelectedIconColor,
    )
}

object CustomColor {
    var themeState = MutableStateFlow(true)
        private set

    private val currentState: Boolean
        get() = themeState.value

    fun toggleTheme(isDarkTheme: Boolean) {
        themeState.value = isDarkTheme
    }

    val current: CustomColors
    @Composable @ReadOnlyComposable get() = LocalTheme.current
}


@Composable
infix fun Color.or(light: Color): Color {
    return if (CustomColor.themeState.value) this else light
}