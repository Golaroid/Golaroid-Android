package com.idea_festival.presentation.ui.issued_code.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.issued_code.RevealPictureRoute
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel

const val revealPictureRoute = "reveal_picture_route"

fun NavController.navigateToRevealPicture(navOptions: NavOptions? = null) {
    this.navigate(revealPictureRoute, navOptions)
}

fun NavGraphBuilder.revealPictureScreen(
    onButtonClick: () -> Unit,
    cameraViewModel: CameraViewModel
) {
    composable(route = revealPictureRoute) {
        RevealPictureRoute(
            onButtonClick = onButtonClick,
            cameraViewModel = cameraViewModel
        )
    }
}