package com.idea_festival.presentation.navigation

import android.graphics.Bitmap
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
import com.idea_festival.presentation.ui.issued_code.navigation.navigateToIssuedCode
import com.idea_festival.presentation.ui.issued_code.navigation.navigateToRevealPicture
import com.idea_festival.presentation.ui.issued_code.navigation.revealPictureScreen
import com.idea_festival.presentation.ui.main.navigation.mainRoute
import com.idea_festival.presentation.ui.main.navigation.mainScreen
import com.idea_festival.presentation.ui.main.navigation.navigateToMain
import com.idea_festival.presentation.ui.main.navigation.navigateToTodayImage
import com.idea_festival.presentation.ui.main.navigation.todayImageRoute
import com.idea_festival.presentation.ui.main.navigation.todayImageScreen
import com.idea_festival.presentation.ui.search_result.navigation.existCodeScreen
import com.idea_festival.presentation.ui.search_result.navigation.navigateToExistCode
import com.idea_festival.presentation.ui.search_result.navigation.noExistCodeScreen
import com.idea_festival.presentation.ui.select_frame.navigation.navigateToPrintSuccess
import com.idea_festival.presentation.ui.select_frame.navigation.navigateToSelectFrame
import com.idea_festival.presentation.ui.select_frame.navigation.selectFrameScreen
import com.idea_festival.presentation.ui.select_image.navigation.navigateToSelectImage
import com.idea_festival.presentation.ui.select_image.navigation.selectImageScreen
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel
import com.idea_festival.presentation.ui.viewmodel.ImageViewModel
import com.idea_festival.presentation.ui.viewmodel.PostViewModel

@Composable
fun GolaroidNavHost(
    appState: GolaroidAppState,
    modifier: Modifier = Modifier,
    startDestination: String = mainRoute,
    postViewModel: PostViewModel,
    cameraViewModel: CameraViewModel
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        mainScreen(
            onTakePictureButtonClick = navController::navigateToCapture,
            onSearchButtonClick = navController::navigateToExistCode,
            onImageClick = navController::navigateToTodayImage,
            postViewModel = postViewModel
        )

        todayImageScreen(
            onCheckButtonClick = navController::popBackStack,
            postViewModel = postViewModel
        )

        captureScreen(
            onBackClick = navController::popBackStack,
            onTakePictureFinish = navController::navigateToRevealPicture,
            cameraViewModel = cameraViewModel,
            postViewModel = postViewModel
        )

        existCodeScreen(
            onTakePictureButtonClick = navController::navigateToCapture,
            onBackClick = navController::popBackStack,
            postViewModel = postViewModel
        )

        noExistCodeScreen(
            onTakePictureButtonClick = navController::navigateToCapture,
            onBackClick = navController::popBackStack,
            postViewModel = postViewModel
        )

        issuedCodeScreen(
            onNextButtonClick = navController::navigateToRevealPicture,
            cameraViewModel = cameraViewModel
        )

        revealPictureScreen(
            onButtonClick = navController::navigateToInputInformation,
            cameraViewModel = cameraViewModel
        )

        inputInformationScreen(
            onNextButtonClick = navController::navigateToSelectImage,
            cameraViewModel = cameraViewModel
        )

        uploadImageSuccessScreen(
            onCheckButtonClick = navController::navigateToSelectImage,
            cameraViewModel = cameraViewModel
        )

        selectImageScreen(
            onNextButtonClick = navController::navigateToSelectFrame,
            imageArray = navController.currentBackStackEntry?.arguments?.get("imageArray") as? MutableList<Bitmap>,
            cameraViewModel = cameraViewModel
        )

        selectFrameScreen(
            onNextButtonClick = navController::navigateToUploadImageSuccess,
            onPrintButtonClick = navController::navigateToPrintSuccess,
            cameraViewModel = cameraViewModel
        )

        uploadImageSuccessScreen(
            onCheckButtonClick = navController::navigateToMain,
            cameraViewModel = cameraViewModel
        )
    }
}