package com.idea_festival.presentation.ui.issued_code.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.issued_code.RevealPictureRoute

const val revealPictureRoute = "reveal_picture_route"

fun NavController.navigateToRevealPicture(navOptions: NavOptions? = null) {
    this.navigate(revealPictureRoute, navOptions)
}

fun NavGraphBuilder.revealPictureScreen(
    onApproveButtonClick: () -> Unit,
    onRejectButtonClick: () -> Unit,
) {
    composable(route = revealPictureRoute) {
        RevealPictureRoute(
            onApproveButtonClick = onApproveButtonClick,
            onRejectButtonClick = onRejectButtonClick
        )
    }
}