package com.project.memo.core.designsystem.component

import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItemColors
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

//@Composable
//fun CustomNavigationSuiteScaffold(
//    navigationSuiteItems: CustomNavigationSuiteScope.() -> Unit,
//    modifier: Modifier = Modifier,
//    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
//    content: @Composable () -> Unit,
//) {
//    val layoutType = NavigationSuiteScaffoldDefaults
//        .calculateFromAdaptiveInfo(windowAdaptiveInfo)
//    val navigationSuiteItemColors = NavigationSuiteItemColors(
//        navigationBarItemColors = NavigationBarItemDefaults.colors(
//            selectedIconColor = NiaNavigationDefaults.navigationSelectedItemColor(),
//            unselectedIconColor = NiaNavigationDefaults.navigationContentColor(),
//            selectedTextColor = NiaNavigationDefaults.navigationSelectedItemColor(),
//            unselectedTextColor = NiaNavigationDefaults.navigationContentColor(),
//            indicatorColor = NiaNavigationDefaults.navigationIndicatorColor(),
//        ),
//        navigationRailItemColors = NavigationRailItemDefaults.colors(
//            selectedIconColor = NiaNavigationDefaults.navigationSelectedItemColor(),
//            unselectedIconColor = NiaNavigationDefaults.navigationContentColor(),
//            selectedTextColor = NiaNavigationDefaults.navigationSelectedItemColor(),
//            unselectedTextColor = NiaNavigationDefaults.navigationContentColor(),
//            indicatorColor = NiaNavigationDefaults.navigationIndicatorColor(),
//        ),
//        navigationDrawerItemColors = NavigationDrawerItemDefaults.colors(
//            selectedIconColor = NiaNavigationDefaults.navigationSelectedItemColor(),
//            unselectedIconColor = NiaNavigationDefaults.navigationContentColor(),
//            selectedTextColor = NiaNavigationDefaults.navigationSelectedItemColor(),
//            unselectedTextColor = NiaNavigationDefaults.navigationContentColor(),
//        ),
//    )
//
//    NavigationSuiteScaffold(
//        navigationSuiteItems = {
//            CustomNavigationSuiteScope(
//                navigationSuiteScope = this,
//                navigationSuiteItemColors = navigationSuiteItemColors,
//            ).run(navigationSuiteItems)
//        },
//        layoutType = layoutType,
//        containerColor = Color.Transparent,
//        navigationSuiteColors = NavigationSuiteDefaults.colors(
//            navigationBarContentColor = NiaNavigationDefaults.navigationContentColor(),
//            navigationRailContainerColor = Color.Transparent,
//        ),
//        modifier = modifier,
//    ) {
//        content()
//    }
//}
//
//class CustomNavigationSuiteScope internal constructor(
//    private val navigationSuiteScope: NavigationSuiteScope,
//    private val navigationSuiteItemColors: NavigationSuiteItemColors,
//) {
//    fun item(
//        selected: Boolean,
//        onClick: () -> Unit,
//        modifier: Modifier = Modifier,
//        icon: @Composable () -> Unit,
//        selectedIcon: @Composable () -> Unit = icon,
//        label: @Composable (() -> Unit)? = null,
//    ) = navigationSuiteScope.item(
//        selected = selected,
//        onClick = onClick,
//        icon = {
//            if (selected) {
//                selectedIcon()
//            } else {
//                icon()
//            }
//        },
//        label = label,
//        colors = navigationSuiteItemColors,
//        modifier = modifier,
//    )
//}