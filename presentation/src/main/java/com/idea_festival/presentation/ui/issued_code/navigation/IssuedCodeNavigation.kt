package com.idea_festival.presentation.ui.issued_code.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.idea_festival.presentation.ui.issued_code.IssuedCodeRoute

const val issuedCodeRoute = "issued_code_route"

fun NavController.navigateToIssuedCode(navOptions: NavOptions? = null) {
    this.navigate(issuedCodeRoute, navOptions)
}

fun NavGraphBuilder.issuedCodeScreen(
    onNextButtonClick: () -> Unit,
) {
    composable(route = issuedCodeRoute) {
        IssuedCodeRoute(
            onNextButtonClick = onNextButtonClick
        )
    }
}