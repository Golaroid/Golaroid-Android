package com.idea_festival.presentation.ui.search_result.screen

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.component.button.GolaroidButton
import com.idea_festival.design_system.component.gif.FailedGif
import com.idea_festival.design_system.component.icon.ClipboardIcon
import com.idea_festival.design_system.component.icon.GoBackIcon
import com.idea_festival.design_system.component.tobar.GoBackTopBar
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.presentation.ui.viewmodel.PostViewModel

@Composable
fun NoExistCodeRoute(
    onTakePictureButtonClick: () -> Unit,
    onBackClick: () -> Unit,
    postViewModel: PostViewModel
) {
    NoExistCodeScreen(
        onTakePictureButtonClick = onTakePictureButtonClick,
        onBackClick = onBackClick,
        code = postViewModel.savedCode.value
    )
}

@Composable
fun NoExistCodeScreen(
    onTakePictureButtonClick: () -> Unit,
    onBackClick: () -> Unit,
    code: String
) {
    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = colors.BLACK)
        ) {
            Spacer(modifier = Modifier.height(22.dp))

            GoBackTopBar(
                icon = { (GoBackIcon()) },
                text = "돌아가기"
            ) {
                onBackClick()
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = code,
                    style = typography.headlineSmall,
                    color = colors.WHITE,
                )

                Spacer(modifier = Modifier.width(14.dp))

                ClipboardIcon(modifier = Modifier.padding(top = 4.dp))

                Spacer(modifier = Modifier.weight(1f))

            }
            Box(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                FailedGif(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.Center)
                )

                Text(
                    text = "해당되는 코드가 존재하지않습니다.",
                    style = typography.labelMedium,
                    color = colors.WHITE,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 278.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            GolaroidButton(
                text = "사진찍기",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 36.dp)
            ) {
                onTakePictureButtonClick()
            }
        }
    }
}

@Preview
@Composable
fun NoExistCodeScreenPre() {
    NoExistCodeScreen(
        onTakePictureButtonClick = {},
        onBackClick = {},
        code = ""
    )
}