package com.idea_festival.presentation.ui.input_information.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.input_information.screen.UploadImageSuccessRoute

const val uploadImageSuccessRoute = "upload_image_success_route"

fun NavController.navigateToUploadImageSuccess(navOptions: NavOptions? = null) {
    this.navigate(uploadImageSuccessRoute, navOptions)
}

fun NavGraphBuilder.uploadImageSuccessScreen(
    onCheckButtonClick:() -> Unit
) {
    composable(route = uploadImageSuccessRoute) {
        UploadImageSuccessRoute(
            onCheckButtonClick = onCheckButtonClick
        )
    }
}