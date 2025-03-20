package com.project.memo.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.project.memo.app.AppState
import com.project.memo.navigation.route.HomeRoute
import com.project.memo.navigation.route.homeScreen
import com.project.memo.navigation.route.settingScreen

@Composable
fun CustomNavHost(
    appState: AppState,
    onShowSnackbar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        homeScreen(
            onTopicClick = {  }, // TODO
            onShowSnackbar = onShowSnackbar,
        )
        settingScreen(
            onShowSnackbar = onShowSnackbar
        )
    }
}