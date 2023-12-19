package com.idea_festival.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.idea_festival.presentation.ui.GolaroidAppState
import com.idea_festival.presentation.ui.capture.navigation.navigateToCapture
import com.idea_festival.presentation.ui.main.navigation.mainRoute
import com.idea_festival.presentation.ui.main.navigation.mainScreen

@Composable
fun GolaroidNavHost(
    appState: GolaroidAppState,
    modifier: Modifier = Modifier,
    startDestination: String = mainRoute,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        mainScreen(
            onTakePictureButtonClick = navController::navigateToCapture
        )
    }
}