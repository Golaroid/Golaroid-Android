package com.idea_festival.presentation.ui.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.main.screen.MainRoute

const val mainRoute = "main_route"

fun NavController.navigateToMain(navOptions: NavOptions? = null ) {
    this.navigate(mainRoute, navOptions)
}

fun NavGraphBuilder.mainScreen(onTakePictureButtonClick: () -> Unit) {
    composable(route = mainRoute) {
        MainRoute(onTakePictureButtonClick = onTakePictureButtonClick)
    }
}