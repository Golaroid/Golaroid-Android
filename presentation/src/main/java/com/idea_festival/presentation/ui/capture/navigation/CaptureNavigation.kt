package com.idea_festival.presentation.ui.capture.navigation


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.capture.CaptureRoute
import com.idea_festival.presentation.ui.main.screen.MainRoute

const val captureRoute = "capture_Route"

fun NavController.navigateToCapture(navOptions: NavOptions? = null ) {
    this.navigate(captureRoute, navOptions)
}

fun NavGraphBuilder.mainScreen() {
    composable(route = captureRoute) {
        CaptureRoute()
    }
}