package com.idea_festival.presentation.ui.search_result.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.search_result.screen.ExistCodeRoute
import com.idea_festival.presentation.ui.search_result.screen.NoExistCodeRoute

const val existCodeRoute = "exist_code_route"

const val noExistCodeRoute = "no_exist_code_route"

fun NavController.navigateToExistCode(navOptions: NavOptions? = null) {
    this.navigate(existCodeRoute, navOptions)
}

fun NavController.navigateToNoExistCode(navOptions: NavOptions? = null) {
    this.navigate(noExistCodeRoute, navOptions)
}

fun NavGraphBuilder.existCodeScreen(
    onTakePictureButtonClick: () -> Unit,
    onBackClick: () -> Unit
) {
    composable(route = existCodeRoute) {
        ExistCodeRoute (
            onTakePictureButtonClick = onTakePictureButtonClick,
            onBackClick = onBackClick
        )
    }
}

fun NavGraphBuilder.noExistCodeScreen(
    onTakePictureButtonClick: () -> Unit,
    onBackClick: () -> Unit
) {
    composable(route = noExistCodeRoute) {
        NoExistCodeRoute(
            onTakePictureButtonClick = onTakePictureButtonClick,
            onBackClick = onBackClick
        )
    }
}