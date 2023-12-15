package com.idea_festival.design_system.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import com.idea_festival.design_system.theme.color.ColorTheme
import com.idea_festival.design_system.theme.color.GolaroidColor

@Composable
fun GolaroidAndroidTheme(
    colors: ColorTheme = GolaroidColor,
    typography: Typography = Typography,
    content: @Composable (colors: ColorTheme, typography: Typography) -> Unit
) {
    content(colors, typography)
}