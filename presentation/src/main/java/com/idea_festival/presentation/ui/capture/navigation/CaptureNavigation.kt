package com.idea_festival.presentation.ui.capture.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.capture.CaptureRoute
import com.idea_festival.presentation.ui.capture.CaptureWithCodeRoute
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel
import com.idea_festival.presentation.ui.viewmodel.PostViewModel

const val captureWithCodeRoute = "capture_with_code_route"

const val captureRoute = "capture_route"

fun NavController.navigateToCaptureWithCode(navOptions: NavOptions? = null) {
    this.navigate(captureWithCodeRoute, navOptions)
}

fun NavController.navigateToCapture(navOptions: NavOptions? = null) {
    this.navigate(captureRoute, navOptions)
}

fun NavGraphBuilder.captureWithCodeScreen(
    onBackClick: () -> Unit,
    onTakePictureFinish: () -> Unit,
    cameraViewModel: CameraViewModel,
    postViewModel: PostViewModel
) {
    composable(route = captureWithCodeRoute) {
        CaptureWithCodeRoute(
            onBackClick = onBackClick,
            onTakePictureFinish = onTakePictureFinish,
            cameraViewModel = cameraViewModel,
            postViewModel = postViewModel
        )
    }
}

fun NavGraphBuilder.captureScreen(
    onBackClick: () -> Unit,
    onTakePictureFinish: () -> Unit,
    cameraViewModel: CameraViewModel,
) {
    composable(route = captureRoute) {
        CaptureRoute(
            onTakePictureFinish = onTakePictureFinish,
            onBackClick = onBackClick,
            cameraViewModel = cameraViewModel,
        )
    }
}