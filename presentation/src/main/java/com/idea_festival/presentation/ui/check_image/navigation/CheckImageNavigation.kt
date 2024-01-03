package com.idea_festival.presentation.ui.check_image.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.check_image.screen.CheckImageRoute
import com.idea_festival.presentation.ui.check_image.screen.CheckImageWithCodeRoute
import com.idea_festival.presentation.ui.viewmodel.ImageViewModel
import com.idea_festival.presentation.ui.viewmodel.PostViewModel

const val checkImageRoute = "check_image_route"

const val checkImageWithCodeRoute = "check_image_with_code_route"
fun NavController.navigateToCheckImage(navOptions: NavOptions? = null) {
    this.navigate(checkImageRoute, navOptions)
}

fun NavController.navigateToCheckImageWithCode(navOptions: NavOptions? = null) {
    this.navigate(checkImageWithCodeRoute, navOptions)
}
fun NavGraphBuilder.checkImageScreen(
    imageViewModel: ImageViewModel,
    onNextButtonClick: () -> Unit

) {
    composable(route = checkImageRoute) {
        CheckImageRoute(
            imageViewModel = imageViewModel,
            onNextButtonClick = onNextButtonClick
        )
    }
}

fun NavGraphBuilder.checkImageWithCodeScreen(
    postViewModel: PostViewModel,
    imageViewModel: ImageViewModel,
    onNextButtonClick: () -> Unit

) {
    composable(route = checkImageWithCodeRoute) {
        CheckImageWithCodeRoute(
            imageViewModel = imageViewModel,
            onNextButtonClick = onNextButtonClick,
            postViewModel = postViewModel
        )
    }
}
