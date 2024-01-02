package com.idea_festival.presentation.ui.capture.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.capture.CaptureRoute
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel
import com.idea_festival.presentation.ui.viewmodel.PostViewModel

const val captureRoute = "capture_Route"

fun NavController.navigateToCapture(navOptions: NavOptions? = null) {
    this.navigate(captureRoute, navOptions)
}

fun NavGraphBuilder.captureScreen(
    onBackClick: () -> Unit,
    onTakePictureFinish: () -> Unit,
    cameraViewModel: CameraViewModel,
    postViewModel: PostViewModel
) {
    composable(route = captureRoute) {
        CaptureRoute(
            onBackClick = onBackClick,
            onTakePictureFinish = onTakePictureFinish,
            cameraViewModel = cameraViewModel,
            postViewModel = postViewModel
        )
    }
}