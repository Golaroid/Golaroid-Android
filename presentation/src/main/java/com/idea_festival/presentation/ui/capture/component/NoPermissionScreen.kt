package com.idea_festival.presentation.ui.capture.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.component.button.GolaroidButton
import com.idea_festival.design_system.theme.GolaroidAndroidTheme


@Composable
fun NoPermissionScreen(
    onRequestPermission: () -> Unit,
) {
    NoPermissionContent(
        onRequestPermission = onRequestPermission
    )
}

@Composable
private fun NoPermissionContent(
    onRequestPermission: () -> Unit,
) {
    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colors.BLACK),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "권한이 없습니다.",
                style = typography.titleLarge,
                color = colors.WHITE,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(horizontal = 20.dp)
            )
            Text(
                text = "사진을 촬영하기위해 카메라옵션을 허용해주세요.",
                style = typography.titleSmall,
                color = colors.WHITE,
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 20.dp)
            )
            GolaroidButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp), onClick = onRequestPermission, text = "권한 허용"
            )
        }
    }
}

@Preview
@Composable
private fun Preview_NoPermissionContent() {
    NoPermissionContent(
        onRequestPermission = {}
    )
}