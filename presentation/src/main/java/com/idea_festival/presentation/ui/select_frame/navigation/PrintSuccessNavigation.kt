package com.idea_festival.presentation.ui.select_frame.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.select_frame.PrintSuccessRoute

const val printSuccessRoute = "print_success_route"

fun NavController.navigateToPrintSuccess(navOptions: NavOptions? = null) {
    this.navigate(printSuccessRoute, navOptions)
}

fun NavGraphBuilder.printSuccessScreen(
    onNextButtonClick: () -> Unit,
) {
    composable(route = printSuccessRoute) {
        PrintSuccessRoute(
            onNextButtonClick = onNextButtonClick
        )
    }
}