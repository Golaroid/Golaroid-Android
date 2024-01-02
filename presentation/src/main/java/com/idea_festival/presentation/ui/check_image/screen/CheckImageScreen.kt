package com.idea_festival.presentation.ui.check_image.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.idea_festival.design_system.theme.GolaroidAndroidTheme

@Composable
fun CheckImageScreen() {
    GolaroidAndroidTheme { colors, typography ->
        Box(
            modifier = Modifier
                .background(color = colors.BLACK)
                .fillMaxSize()
        ) {

        }
    }
}