package com.idea_festival.presentation.ui.select_image.navigation

import android.graphics.Bitmap
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.idea_festival.presentation.ui.select_image.SelectImageRoute
import com.idea_festival.presentation.ui.select_image.SelectImageWithCodeRoute
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel
import com.idea_festival.presentation.ui.viewmodel.ImageViewModel
import com.idea_festival.presentation.ui.viewmodel.PostViewModel

const val selectImageRoute = "select_image_route"

const val selectImageWithCodeRoute = "select_image_with_code_route"
fun NavController.navigateToSelectImage(navOptions: NavOptions? = null) {
    this.navigate(selectImageRoute, navOptions)
}

fun NavController.navigateToSelectImageWithCode(navOptions: NavOptions? = null) {
    this.navigate(selectImageWithCodeRoute, navOptions)
}

fun NavGraphBuilder.selectImageScreen(
    onNextButtonClick:() -> Unit,
    imageArray: MutableList<Bitmap>? = null,
    cameraViewModel: CameraViewModel,
    imageViewModel: ImageViewModel,
    onGoButtonClick: () -> Unit,
    ) {
    composable (
        route = selectImageRoute
    ){
        SelectImageRoute(
            onNextButtonClick = {},
            cameraViewModel = cameraViewModel,
            imageViewModel = imageViewModel,
            onGoButtonClick = onGoButtonClick
        )
    }
}

fun NavGraphBuilder.selectImageWithCodeScreen(
    onNextButtonClick:() -> Unit,
    imageArray: MutableList<Bitmap>? = null,
    cameraViewModel: CameraViewModel,
    postViewModel: PostViewModel,
    onGoButtonClick: () -> Unit,
    imageViewModel: ImageViewModel
) {
    composable (
        route = selectImageWithCodeRoute
    ){
        SelectImageWithCodeRoute(
            onNextButtonClick = {},
            cameraViewModel = cameraViewModel,
            postViewModel = postViewModel,
            onGoButtonClick = onGoButtonClick,
            imageViewModel = imageViewModel
        )
    }
}