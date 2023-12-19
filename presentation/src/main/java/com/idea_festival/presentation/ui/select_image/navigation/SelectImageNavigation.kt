package com.idea_festival.presentation.ui.select_image.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.select_image.SelectImageRoute

const val selectImageRoute = "select_image_route"

fun NavController.navigateToSelectImage(navOptions: NavOptions? = null) {
    this.navigate(selectImageRoute, navOptions)
}

fun NavGraphBuilder.selectImageScreen(
    onNextButtonClick:() -> Unit
) {
    composable(route = selectImageRoute) {
        SelectImageRoute(
            onNextButtonClick = onNextButtonClick
        )
    }
}