package com.project.memo.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import com.project.memo.core.designsystem.extention.noRippleClickable
import com.project.memo.core.designsystem.theme.CustomColor
import com.project.memo.navigation.CustomNavHost
import com.project.memo.navigation.TopLevelDestination
import kotlin.reflect.KClass


@Composable
fun App(
    appState: AppState,
    modifier: Modifier = Modifier,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val currentDestination = appState.currentDestination

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        containerColor = CustomColor.current.transparent,
        contentColor = CustomColor.current.backgroundColor,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        snackbarHost = {
            SnackbarHost(
                snackbarHostState,
                modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing)
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxSize()
            ) {
                appState.topLevelDestinations.forEach { destination ->
                    Box(
                        modifier = Modifier
                            .background(
                                color = if (currentDestination.isRouteInHierarchy(destination.baseRoute))
                                        CustomColor.current.selectedBackground
                                    else CustomColor.current.buttonColor
                            )
                            .fillMaxHeight()
                            .weight(1f)
                            .noRippleClickable { appState.navigateToTopLevelDestination(destination) },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = destination.iconText,
                            color = CustomColor.current.textColor,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal
                    )
                )
        ) {
            val destination = appState.currentTopLevelDestination
            var shouldShowTopAppBar = false

            if (destination != null) {
                shouldShowTopAppBar = true
//                NiaTopAppBar(
//                    titleRes = destination.titleTextId,
//                    navigationIcon = NiaIcons.Search,
//                    navigationIconContentDescription = stringResource(
//                        id = settingsR.string.feature_settings_top_app_bar_navigation_icon_description,
//                    ),
//                    actionIcon = NiaIcons.Settings,
//                    actionIconContentDescription = stringResource(
//                        id = settingsR.string.feature_settings_top_app_bar_action_icon_description,
//                    ),
//                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                        containerColor = Color.Transparent,
//                    ),
//                    onActionClick = { onTopAppBarActionClick() },
//                    onNavigationClick = { appState.navigateToSearch() },
//                )
            }

            Box(
                modifier = Modifier.consumeWindowInsets(
                    if (shouldShowTopAppBar) {
                        WindowInsets.safeDrawing.only(WindowInsetsSides.Top)
                    } else {
                        WindowInsets(0, 0, 0, 0)
                    },
                )
            ) {
                CustomNavHost(
                    appState = appState,
                    onShowSnackbar = { message, action ->
                        snackbarHostState.showSnackbar(
                            message = message,
                            actionLabel = action,
                            duration = SnackbarDuration.Short
                        ) == SnackbarResult.ActionPerformed
                    }
                )
            }
        }
    }
}

private fun NavDestination?.isRouteInHierarchy(route: KClass<*>) =
    this?.hierarchy?.any {
        it.hasRoute(route)
    } ?: false
