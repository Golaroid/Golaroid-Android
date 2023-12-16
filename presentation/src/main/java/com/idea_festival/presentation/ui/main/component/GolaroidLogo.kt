package com.idea_festival.presentation.ui.main.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.golaroid_android.presentation.R

@Composable
fun GolaroidLogo(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = com.idea_festival.golaroid_android.design_system.R.drawable.ic_logo),
        contentDescription = "골라로이드 로고",
        modifier = modifier
    )
}