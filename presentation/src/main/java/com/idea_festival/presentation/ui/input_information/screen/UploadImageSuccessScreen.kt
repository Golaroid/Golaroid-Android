package com.idea_festival.presentation.ui.input_information.screen

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.component.button.GolaroidButton
import com.idea_festival.design_system.component.gif.SuccessGif
import com.idea_festival.design_system.component.icon.CutPurpleStickIcon
import com.idea_festival.design_system.component.icon.GreenStarIcon
import com.idea_festival.design_system.component.icon.StarIcon
import com.idea_festival.design_system.component.icon.UnCutOrangeCameraIcon
import com.idea_festival.design_system.theme.GolaroidAndroidTheme

@Composable
fun UploadImageSuccessRoute(
    onCheckButtonClick:() -> Unit
) {
    UploadImageSuccessScreen(
        onCheckButtonClick = onCheckButtonClick
    )
}
@Composable
fun UploadImageSuccessScreen(
    onCheckButtonClick:() -> Unit
) {
    GolaroidAndroidTheme { colors, typography ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = colors.BLACK)
        ) {
            Column {
                Spacer(modifier = Modifier.height(43.dp))
                StarIcon(
                    modifier = Modifier
                        .width(56.dp)
                        .height(56.dp)
                )
            }


            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 56.dp)
            ) {
                SuccessGif(
                    modifier = Modifier
                        .width(280.dp)
                        .height(280.dp)
                        .align(Alignment.Center)
                )

                Text(
                    text = "이미지 업로드가 완료되었습니다.",
                    style = typography.labelMedium,
                    color = colors.WHITE,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 164.dp)
                )
            }

            Row(
                modifier = Modifier.padding(top = 376.dp)
            ) {
                UnCutOrangeCameraIcon(
                    modifier = Modifier
                        .width(130.dp)
                        .height(130.dp)
                )

                Spacer(modifier = Modifier.weight(1f))


                GreenStarIcon(
                    modifier = Modifier
                        .width(56.dp)
                        .height(56.dp)
                )

                CutPurpleStickIcon(
                    modifier = Modifier
                        .padding(top = 46.dp)
                        .width(68.dp)
                        .height(122.dp)
                )
            }
            GolaroidButton(
                text = "확인",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 36.dp)
            ) {
                onCheckButtonClick()
            }
        }
    }
}

@Preview
@Composable
fun UploadImageScreenPre() {
    UploadImageSuccessScreen(onCheckButtonClick = {})
}