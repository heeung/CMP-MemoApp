package com.project.memo.navigation.route

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.project.memo.home.presentation.HomeRoute
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

fun NavController.navigateToHome(navOptions: NavOptions) =
    navigate(route = HomeRoute, navOptions)

fun NavGraphBuilder.homeScreen(
    modifier: Modifier = Modifier,
    onTopicClick: (String) -> Unit,
    onShowSnackbar: suspend (String, String?) -> Boolean
) {
    composable<HomeRoute> {
        HomeRoute(modifier, onTopicClick, onShowSnackbar)
    }
}