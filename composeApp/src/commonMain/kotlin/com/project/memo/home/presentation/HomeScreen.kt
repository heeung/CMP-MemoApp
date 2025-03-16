package com.project.memo.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.project.memo.core.presentation.common.CustomButton
import com.project.memo.core.presentation.theme.CustomColor
import com.project.memo.home.presentation.intent.HomeEvent
import com.project.memo.home.presentation.state.HomeUiState
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun HomeRoute(
    onTopicClick: (String) -> Unit,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel<HomeViewModel>(),
) {
    val homeState by viewModel.homeState.collectAsStateWithLifecycle()

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
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CustomButton(
            modifier = Modifier
                .align(Alignment.TopCenter),
            normalColor = CustomColor.Black,
            pressColor = CustomColor.PressBlack,
            onClick = { onToggleButtonClicked() },
        ) {
            Text(
                text = "toggle button",
                fontSize = 16.sp,
                style = TextStyle(
                    lineHeight = TextUnit.Unspecified
                )
            )
        }
    }
}