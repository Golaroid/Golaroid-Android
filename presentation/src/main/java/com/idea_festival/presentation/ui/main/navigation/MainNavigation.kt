package com.idea_festival.presentation.ui.main.navigation

import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.GolaroidAppState
import com.idea_festival.presentation.ui.main.screen.MainRoute
import com.idea_festival.presentation.ui.viewmodel.PostViewModel

const val mainRoute = "main_route"

fun NavController.navigateToMain(navOptions: NavOptions? = null) {
    this.navigate(mainRoute, navOptions)
}

fun NavGraphBuilder.mainScreen(
    onTakePictureButtonClick: () -> Unit,
    onImageClick: () -> Unit,
    onSearchButtonClick: () -> Unit,
    postViewModel: PostViewModel
) {
    composable(route = mainRoute) {
        MainRoute(
            onTakePictureButtonClick = onTakePictureButtonClick,
            onImageClick = onImageClick,
            onSearchButtonClick = onSearchButtonClick,
            postViewModel = postViewModel
        )
    }
}