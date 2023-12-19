package com.idea_festival.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.idea_festival.presentation.ui.GolaroidAppState
import com.idea_festival.presentation.ui.capture.navigation.captureScreen
import com.idea_festival.presentation.ui.capture.navigation.navigateToCapture
import com.idea_festival.presentation.ui.input_information.navigation.inputInformationScreen
import com.idea_festival.presentation.ui.input_information.navigation.navigateToInputInformation
import com.idea_festival.presentation.ui.input_information.navigation.navigateToUploadImageSuccess
import com.idea_festival.presentation.ui.input_information.navigation.uploadImageSuccessScreen
import com.idea_festival.presentation.ui.issued_code.navigation.issuedCodeScreen
import com.idea_festival.presentation.ui.issued_code.navigation.navigateToRevealPicture
import com.idea_festival.presentation.ui.issued_code.navigation.revealPictureScreen
import com.idea_festival.presentation.ui.main.navigation.mainRoute
import com.idea_festival.presentation.ui.main.navigation.mainScreen
import com.idea_festival.presentation.ui.main.navigation.navigateToMain
import com.idea_festival.presentation.ui.search_result.navigation.existCodeScreen
import com.idea_festival.presentation.ui.search_result.navigation.navigateToExistCode
import com.idea_festival.presentation.ui.search_result.navigation.noExistCodeScreen
import com.idea_festival.presentation.ui.select_frame.navigation.navigateToPrintSuccess
import com.idea_festival.presentation.ui.select_frame.navigation.navigateToSelectFrame
import com.idea_festival.presentation.ui.select_frame.navigation.selectFrameScreen
import com.idea_festival.presentation.ui.select_image.navigation.navigateToSelectImage
import com.idea_festival.presentation.ui.select_image.navigation.selectImageScreen

@Composable
fun GolaroidNavHost(
    appState: GolaroidAppState,
    modifier: Modifier = Modifier,
    startDestination: String = mainRoute,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        mainScreen(
            onTakePictureButtonClick = navController::navigateToCapture,
            onSearchButtonClick = navController::navigateToExistCode,
            onImageClick = {}
        )

        captureScreen(
            onBackClick = navController::popBackStack
        )

        existCodeScreen(
            onTakePictureButtonClick = navController::navigateToCapture,
            onBackClick = navController::popBackStack
        )

        noExistCodeScreen(
            onTakePictureButtonClick = navController::navigateToCapture,
            onBackClick = navController::popBackStack
        )

        issuedCodeScreen(
            onNextButtonClick = navController::navigateToRevealPicture,
        )

        revealPictureScreen(
            onApproveButtonClick = navController::navigateToInputInformation,
            onRejectButtonClick = navController::navigateToInputInformation,
        )

        inputInformationScreen(
            onNextButtonClick = navController::navigateToUploadImageSuccess
        )

        uploadImageSuccessScreen(
            onCheckButtonClick = navController::navigateToSelectImage
        )

        selectImageScreen(
            onNextButtonClick = navController::navigateToSelectFrame
        )

        selectFrameScreen(
            onNextButtonClick = navController::navigateToMain,
            onPrintButtonClick = navController::navigateToPrintSuccess
        )
    }
}