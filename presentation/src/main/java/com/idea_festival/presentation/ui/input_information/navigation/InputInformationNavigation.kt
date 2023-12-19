package com.idea_festival.presentation.ui.input_information.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.input_information.screen.InputInformationRoute

const val inputInformationRoute = "input_information_route"

fun NavController.navigateToInputInformation(navOptions: NavOptions? = null) {
    this.navigate(inputInformationRoute, navOptions)
}

fun NavGraphBuilder.inputInformationScreen(
    onNextButtonClick: () -> Unit,
) {
    composable(route = inputInformationRoute) {
        InputInformationRoute(
            onNextButtonClick = onNextButtonClick
        )
    }
}