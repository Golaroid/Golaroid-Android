package com.idea_festival.presentation.ui.issued_code

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.component.button.GolaroidButton
import com.idea_festival.design_system.component.icon.ClipboardIcon
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel
import com.idea_festival.presentation.ui.viewmodel.PostViewModel

@Composable
fun IssuedCodeRoute(
    onNextButtonClick: () -> Unit,
    cameraViewModel: CameraViewModel
) {
    IssuedCodeScreen(
        onNextButtonClick = onNextButtonClick
    )
}

@Composable
fun IssuedCodeScreen(
    onNextButtonClick: () -> Unit,
) {
    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = colors.BLACK)
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "이동욱" + "님",
                style = typography.titleMedium,
                color = colors.WHITE,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(176.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "F14GH",
                    style = typography.headlineSmall,
                    color = colors.WHITE,
                )

                Spacer(modifier = Modifier.width(12.dp))

                ClipboardIcon(modifier = Modifier.padding(top = 4.dp))

                Spacer(modifier = Modifier.weight(1f))

            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "코드가 완성됐습니다",
                style = typography.titleSmall,
                color = colors.WHITE,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "친구들과 함께 사진을 찍어보세요!",
                style = typography.bodyLarge,
                color = colors.GRAY,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.weight(1f))

            GolaroidButton(
                text = "넘어가기",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 36.dp)
            ) {
                onNextButtonClick()
            }
        }
    }
}

@Preview
@Composable
fun IssuedCodeScreenPre() {
    IssuedCodeScreen(onNextButtonClick = {})
}