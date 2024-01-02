package com.idea_festival.presentation.ui.main.navigation

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.main.screen.TodayImageRoute
import com.idea_festival.presentation.ui.viewmodel.PostViewModel

const val todayImageRoute = "today_image_route"

fun NavController.navigateToTodayImage(navOptions: NavOptions? = null) {
    this.navigate(todayImageRoute, navOptions)
}

fun NavGraphBuilder.todayImageScreen(
    onCheckButtonClick: () -> Unit,
    postViewModel: PostViewModel
) {
    composable(route = todayImageRoute) {
        TodayImageRoute(
            onCheckButtonClick = onCheckButtonClick,
            viewModel = postViewModel
        )
    }
}