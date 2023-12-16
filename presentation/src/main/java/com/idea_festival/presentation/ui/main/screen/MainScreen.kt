package com.idea_festival.presentation.ui.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.presentation.ui.main.component.GolaroidLogo

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun MainScreen(

) {
    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .background(color = colors.BLACK)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            GolaroidLogo(modifier = Modifier
                .width(106.dp)
                .height(23.dp)
                .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
fun MainScreenPre() {
    MainScreen()
}