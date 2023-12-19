package com.idea_festival.presentation.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.presentation.navigation.GolaroidNavHost

@Composable
fun GolaroidApp(
    windowSizeClass: WindowSizeClass,
    appState: GolaroidAppState = rememberGolaroidAppState(windowSizeClass = windowSizeClass),
) {
    GolaroidAndroidTheme { _, _ ->
        GolaroidNavHost(appState = appState)
    }
}