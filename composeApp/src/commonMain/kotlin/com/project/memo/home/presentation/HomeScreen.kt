package com.project.memo.home.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.project.memo.Res
import com.project.memo.compose_multiplatform
import com.project.memo.core.designsystem.component.CustomButton
import com.project.memo.core.designsystem.component.CustomText
import com.project.memo.core.designsystem.theme.CustomColor
import com.project.memo.home.presentation.intent.HomeEvent
import com.project.memo.home.presentation.state.HomeUiState
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    onTopicClick: (String) -> Unit,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    viewModel: HomeViewModel = koinViewModel<HomeViewModel>(),
) {
    val homeState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        modifier = modifier,
        state = homeState,
        onTopicClick = onTopicClick,
        onShowSnackbar = onShowSnackbar,
        onToggleButtonClicked = { viewModel.onEvent(HomeEvent.OnClickToggleButton) }
    )
}

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeUiState,
    onTopicClick: (String) -> Unit,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    onToggleButtonClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomButton(
            modifier = Modifier,
            normalColor = CustomColor.current.buttonColor,
            hoverColor = CustomColor.current.buttonHoverColor,
            pressColor = CustomColor.current.buttonPressColor,
            onClick = {
                onToggleButtonClicked()
            },
        ) {
            CustomText(
                text = "toggle button",
                fontSize = 16.sp,
                color = CustomColor.current.buttonTextColor,
                style = TextStyle(
                    lineHeight = TextUnit.Unspecified
                )
            )
        }
        AnimatedVisibility(state.isOpen) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(Res.drawable.compose_multiplatform), null)
            }
        }
    }
}