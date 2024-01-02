package com.idea_festival.presentation.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.presentation.navigation.GolaroidNavHost
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel
import com.idea_festival.presentation.ui.viewmodel.ImageViewModel
import com.idea_festival.presentation.ui.viewmodel.PostViewModel

@Composable
fun GolaroidApp(
    windowSizeClass: WindowSizeClass,
    appState: GolaroidAppState = rememberGolaroidAppState(windowSizeClass = windowSizeClass),
    postViewModel: PostViewModel,
    imageViewModel: ImageViewModel,
    cameraViewModel: CameraViewModel,
) {
    GolaroidAndroidTheme { _, _ ->
        GolaroidNavHost(
            appState = appState,
            postViewModel = postViewModel,
            cameraViewModel = cameraViewModel,
            imageViewModel = imageViewModel
        )
    }
}