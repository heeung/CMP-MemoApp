package com.project.memo.settings.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.project.memo.core.designsystem.component.CustomSwitch
import com.project.memo.core.designsystem.component.CustomText
import com.project.memo.core.designsystem.theme.CustomColor
import com.project.memo.core.designsystem.theme.CustomFontFamily
import com.project.memo.settings.presentation.state.SettingUiState
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun SettingRoute(
    modifier: Modifier = Modifier,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    viewModel: SettingViewModel = koinViewModel<SettingViewModel>(),
) {
    val settingState by viewModel.uiState.collectAsStateWithLifecycle()
    val isDarkTheme by CustomColor.themeState.collectAsState()

    SettingScreen(
        modifier = modifier,
        state = settingState,
        onShowSnackbar = onShowSnackbar,
        isDarkTheme =  isDarkTheme,
        onThemeChangeButtonClicked = { CustomColor.toggleTheme() }
    )
}

@Composable
internal fun SettingScreen(
    modifier: Modifier = Modifier,
    state: SettingUiState,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    isDarkTheme: Boolean,
    onThemeChangeButtonClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomText(
                modifier = Modifier.weight(1f),
                text = "다크 테마 적용",
                fontSize = 16.sp,
                fontFamily = CustomFontFamily.Bold,
            )
            CustomSwitch(
                modifier = Modifier
                    .width(60.dp),
                checked = isDarkTheme,
                onCheckedChange = {
                    onThemeChangeButtonClicked()
                },
            )
        }

//        CustomButton(
//            modifier = Modifier,
//            normalColor = CustomColor.current.buttonColor,
//            hoverColor = CustomColor.current.buttonHoverColor,
//            pressColor = CustomColor.current.buttonPressColor,
//            onClick = { onThemeChangeButtonClicked() },
//        ) {
//            Text(
//                text = "theme toggle button",
//                fontSize = 16.sp,
//                style = TextStyle(
//                    lineHeight = TextUnit.Unspecified
//                )
//            )
//        }
    }
}