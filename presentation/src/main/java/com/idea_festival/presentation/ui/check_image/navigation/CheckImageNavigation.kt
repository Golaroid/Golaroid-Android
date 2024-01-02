package com.idea_festival.presentation.ui.check_image.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.idea_festival.presentation.ui.viewmodel.ImageViewModel

const val checkImageRoute = "check_image_route"

fun NavController.navigateToCheckImage(navOptions: NavOptions? = null) {
    this.navigate(checkImageRoute, navOptions)
}

fun NavGraphBuilder.checkImageScreen(
    imageViewModel: ImageViewModel
) {

}