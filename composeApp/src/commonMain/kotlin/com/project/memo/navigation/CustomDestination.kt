package com.project.memo.navigation

import com.project.memo.Res
import com.project.memo.icon_home
import com.project.memo.icon_setting
import com.project.memo.navigation.route.HomeRoute
import com.project.memo.navigation.route.SettingRoute
import org.jetbrains.compose.resources.DrawableResource
import kotlin.reflect.KClass

enum class TopLevelDestination(
    val selectedIcon: DrawableResource,
    val unselectedIcon: DrawableResource,
    val iconText: String,
    val titleText: String,
    val route: KClass<*>,
    val baseRoute: KClass<*> = route,
) {
    HOME(
        selectedIcon = Res.drawable.icon_home,
        unselectedIcon = Res.drawable.icon_home,
        iconText = "home",
        titleText = "home",
        route = HomeRoute::class,
    ),
    SETTING(
        selectedIcon = Res.drawable.icon_setting,
        unselectedIcon = Res.drawable.icon_setting,
        iconText = "setting",
        titleText = "setting",
        route = SettingRoute::class,
    )
}