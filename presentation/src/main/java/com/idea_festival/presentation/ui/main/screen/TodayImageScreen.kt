package com.idea_festival.presentation.ui.main.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.component.button.GolaroidButton
import com.idea_festival.design_system.component.frame.RupeeFrame
import com.idea_festival.design_system.theme.GolaroidAndroidTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TodayImageScreen() {
    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = colors.BLACK)
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Row {
                Spacer(modifier = Modifier.weight(1f))
                RupeeFrame(
                )
                Spacer(modifier = Modifier.weight(1f))

            }


            Spacer(modifier = Modifier.weight(1f))

            GolaroidButton(
                text = "확인", modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 36.dp)
            ) {

            }

        }
    }
}

@Preview
@Composable
fun TodayImageScreenPre() {
    TodayImageScreen()
}