package com.idea_festival.presentation.ui.select_frame.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.select_frame.SelectFrameRoute

const val selectFrameRoute = "select_frame_route"

fun NavController.navigateToSelectFrame(navOptions: NavOptions? = null) {
    this.navigate(selectFrameRoute, navOptions)
}

fun NavGraphBuilder.selectFrameScreen(
    onPrintButtonClick: () -> Unit,
    onNextButtonClick: () -> Unit,
) {
    composable(route = selectFrameRoute) {
        SelectFrameRoute(
            onPrintButtonClick = onPrintButtonClick,
            onNextButtonClick = onNextButtonClick
        )
    }
}