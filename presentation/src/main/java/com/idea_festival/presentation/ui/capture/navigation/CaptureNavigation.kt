package com.idea_festival.presentation.ui.capture.navigation

import android.graphics.Bitmap
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.idea_festival.presentation.ui.capture.CaptureRoute
import com.idea_festival.presentation.ui.select_image.navigation.selectImageRoute

const val captureRoute = "capture_Route"

fun NavController.navigateToCapture(navOptions: NavOptions? = null) {
    this.navigate(captureRoute, navOptions)
}

fun NavGraphBuilder.captureScreen(
    onBackClick: () -> Unit,
    onTakePictureFinish: () -> Unit
) {
    composable(route = captureRoute) {
        CaptureRoute(
            onBackClick = onBackClick,
            onTakePictureFinish = onTakePictureFinish,
        )
    }
}