package com.idea_festival.presentation.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.idea_festival.presentation.navigation.TopLevelDestination
import com.idea_festival.presentation.ui.main.navigation.mainRoute
import kotlinx.coroutines.CoroutineScope


@Composable
fun rememberGolaroidAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    windowSizeClass: WindowSizeClass
): GolaroidAppState {
    return remember(
        navController,
        coroutineScope,
        windowSizeClass
    ) {
        GolaroidAppState(
            navController,
            coroutineScope,
            windowSizeClass
        )
    }
}

@Stable
class GolaroidAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    val windowSizeClass: WindowSizeClass
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLeverDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            mainRoute -> TopLevelDestination.MAIN
            else -> null
        }

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()
}
