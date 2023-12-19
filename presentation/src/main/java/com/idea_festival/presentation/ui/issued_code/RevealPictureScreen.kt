package com.idea_festival.presentation.ui.issued_code

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
import com.idea_festival.design_system.component.icon.ClipboardIcon
import com.idea_festival.design_system.component.icon.CutPinkStarIcon
import com.idea_festival.design_system.component.icon.GoBackIcon
import com.idea_festival.design_system.component.icon.GreenStarIcon
import com.idea_festival.design_system.component.icon.OrangeCameraIcon
import com.idea_festival.design_system.component.icon.OrangeCircleIcon
import com.idea_festival.design_system.component.icon.PurpleStickIcon
import com.idea_festival.design_system.component.icon.StarIcon
import com.idea_festival.design_system.component.icon.StarfishStarIcon
import com.idea_festival.design_system.component.icon.UnCutOrangeCameraIcon
import com.idea_festival.design_system.component.tobar.GoBackTopBar
import com.idea_festival.design_system.theme.GolaroidAndroidTheme

@Composable
fun RevealPictureRoute(
    onApproveButtonClick: () -> Unit,
    onRejectButtonClick: () -> Unit,
) {
    RevealPictureScreen(
        onApproveButtonClick = onApproveButtonClick,
        onRejectButtonClick = onRejectButtonClick
    )
}

@Composable
fun RevealPictureScreen(
    onApproveButtonClick: () -> Unit,
    onRejectButtonClick: () -> Unit,
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
                text = "뒤로가기"
            ) {

            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                StarfishStarIcon(
                    modifier = Modifier
                        .width(105.dp)
                        .height(105.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                PurpleStickIcon(modifier = Modifier.wrapContentSize())

                Spacer(modifier = Modifier.width(26.dp))

            }

            Spacer(modifier = Modifier.height(58.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CutPinkStarIcon(
                    modifier = Modifier
                        .width(34.dp)
                        .height(50.dp)
                )


                Spacer(modifier = Modifier.width(44.dp))

                Spacer(modifier = Modifier.weight(0.5f))

                Column {
                    Text(
                        text = "사진을 전체 공개하실건가요?",
                        style = typography.titleMedium,
                        color = colors.WHITE
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "사진을 공개하면 메인페이지에 있는\n 오늘의 사진으로 업로드가 됩니다",
                        style = typography.labelLarge,
                        color = colors.GRAY,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }

                Spacer(modifier = Modifier.weight(3f))

            }

            Spacer(modifier = Modifier.height(78.dp))

            Row(
                modifier = Modifier.padding(end = 13.dp)
            ) {
                UnCutOrangeCameraIcon(
                    modifier = Modifier
                        .width(130.dp)
                        .height(130.dp)
                )

                Spacer(modifier = Modifier.weight(1f))
                Column {

                    GreenStarIcon(
                        modifier = Modifier
                            .width(56.dp)
                            .height(56.dp)
                    )
                    Spacer(modifier = Modifier.height(86.dp))

                    OrangeCircleIcon(
                        modifier = Modifier
                            .width(60.dp)
                            .height(60.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                GolaroidButton(
                    modifier = Modifier.weight(1f),
                    text = "예"
                ) {
                    onApproveButtonClick()
                }

                Spacer(modifier = Modifier.width(20.dp))

                GolaroidButton(
                    modifier = Modifier.weight(1f),
                    text = "아니오"
                ) {
                    onRejectButtonClick()
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

        }
    }
}

@Preview
@Composable
fun RevealPictureScreenPre() {
    RevealPictureScreen(
        onApproveButtonClick = {},
        onRejectButtonClick = {}
    )
}