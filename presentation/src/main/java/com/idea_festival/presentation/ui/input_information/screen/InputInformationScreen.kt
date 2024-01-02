package com.idea_festival.presentation.ui.input_information.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.component.button.GolaroidButton
import com.idea_festival.design_system.component.icon.GoBackIcon
import com.idea_festival.design_system.component.textfield.GolaroidTextFieldWithOutIcon
import com.idea_festival.design_system.component.tobar.GoBackTopBar
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel

@Composable
fun InputInformationRoute(
    onNextButtonClick: () -> Unit,
    viewModel: CameraViewModel
) {
    InputInformationScreen(
        onNextButtonClick = {
            viewModel.userName.value = it
            onNextButtonClick()
        }
    )
}

@Composable
fun InputInformationScreen(
    onNextButtonClick: (String) -> Unit,
) {
    val userName = remember { mutableStateOf("") }
    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = colors.BLACK)
        ) {

            Spacer(modifier = Modifier.height(22.dp))

            GoBackTopBar(
                icon = { (GoBackIcon()) },
                text = "뒤로가기"
            ) {

            }

            Spacer(modifier = Modifier.height(166.dp))

            Column(
                modifier = Modifier.padding(horizontal = 32.dp)

            ) {

                Box(
                    modifier = Modifier
                        .background(
                            color = colors.DARKGRAY2,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Column {
                        Text(
                            text = "닉네임을 입력해 주세요",
                            style = typography.bodySmall,
                            color = colors.WHITE,
                            modifier = Modifier
                                .padding(top = 24.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(29.dp))

                        GolaroidTextFieldWithOutIcon(
                            placeholder = "닉네임을 입력해 주세요",
                            onValueChange = {
                                userName.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 14.dp),
                            value = userName.value
                        )

                        Spacer(modifier = Modifier.height(52.dp))

                    }
                }

            }
            Spacer(modifier = Modifier.weight(1f))

            GolaroidButton(
                text = "넘어가기",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 36.dp)
            ) {
                onNextButtonClick(userName.value)
            }
        }
    }
}

@Preview
@Composable
fun InputInformationScreenPre() {
    InputInformationScreen(
        onNextButtonClick = {}
    )
}