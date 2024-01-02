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
    cameraViewModel: CameraViewModel
) {
    composable (
        route = selectImageRoute
    ){
        SelectImageRoute(
            onNextButtonClick = {},
            cameraViewModel = cameraViewModel
        )
    }
}

fun NavGraphBuilder.selectImageWithCodeScreen(
    onNextButtonClick:() -> Unit,
    imageArray: MutableList<Bitmap>? = null,
    cameraViewModel: CameraViewModel
) {
    composable (
        route = selectImageWithCodeRoute
    ){
        SelectImageWithCodeRoute(
            onNextButtonClick = {},
            cameraViewModel = cameraViewModel
        )
    }
}