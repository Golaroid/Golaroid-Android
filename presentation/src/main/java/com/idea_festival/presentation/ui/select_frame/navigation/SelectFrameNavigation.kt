package com.idea_festival.presentation.ui.select_frame.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.select_frame.SelectFrameRoute
import com.idea_festival.presentation.ui.select_frame.SelectFrameWithCodeRoute
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel
import com.idea_festival.presentation.ui.viewmodel.PostViewModel

const val selectFrameRoute = "select_frame_route"

const val selectFrameWithCodeRoute = "select_frame_with_code_route"
fun NavController.navigateToSelectFrame(navOptions: NavOptions? = null) {
    this.navigate(selectFrameRoute, navOptions)
}

fun NavController.navigateToSelectFrameWithCode(navOptions: NavOptions? = null) {
    this.navigate(selectFrameWithCodeRoute, navOptions)
}
fun NavGraphBuilder.selectFrameScreen(
    onPrintButtonClick: () -> Unit,
    onNextButtonClick: () -> Unit,
    cameraViewModel: CameraViewModel
) {
    composable(route = selectFrameRoute) {
        SelectFrameRoute(
            onPrintButtonClick = onPrintButtonClick,
            onNextButtonClick = onNextButtonClick,
            cameraViewModel = cameraViewModel
        )
    }
}

fun NavGraphBuilder.selectFrameWithCodeScreen(
    onPrintButtonClick: () -> Unit,
    onNextButtonClick: () -> Unit,
    cameraViewModel: CameraViewModel,
    postViewModel: PostViewModel
) {
    composable(route = selectFrameWithCodeRoute) {
        SelectFrameWithCodeRoute(
            onPrintButtonClick = onPrintButtonClick,
            onNextButtonClick = onNextButtonClick,
            cameraViewModel = cameraViewModel,
            postViewModel = postViewModel
        )
    }
}