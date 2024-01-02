package com.idea_festival.presentation.ui.select_image.navigation

import android.graphics.Bitmap
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.idea_festival.presentation.ui.select_image.SelectImageRoute

const val selectImageRoute = "select_image_route"

fun NavController.navigateToSelectImage(navOptions: NavOptions? = null) {
    this.navigate(selectImageRoute, navOptions)
}

fun NavGraphBuilder.selectImageScreen(
    onNextButtonClick:() -> Unit,
    imageArray: MutableList<Bitmap>? = null
) {
    composable (
        route = selectImageRoute
    ){
        SelectImageRoute(
            onNextButtonClick = {},
        )
    }
}