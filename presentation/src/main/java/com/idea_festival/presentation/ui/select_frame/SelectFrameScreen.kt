package com.idea_festival.presentation.ui.select_frame

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.component.image.ChooseImage
import com.idea_festival.design_system.theme.GolaroidAndroidTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SelectFrameScreen() {
    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = colors.BLACK)
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            HorizontalPager(
                pageCount = 10,
                contentPadding = PaddingValues(horizontal = 40.dp)
            ) { page ->

            }

        }
    }
}

@Preview
@Composable
fun SelectFrameScreenPre() {
    SelectFrameScreen()
}