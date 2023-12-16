package com.idea_festival.presentation.ui.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.idea_festival.design_system.component.icon.StarIcon
import com.idea_festival.design_system.component.textfield.GolaroidTextField
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.design_system.theme.pretendard
import com.idea_festival.presentation.ui.main.component.GolaroidLogo
import com.idea_festival.presentation.ui.main.component.PictureCard

@Composable
fun MainScreen(

) {
    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .background(color = colors.BLACK)
        ) {
            Column(
                modifier = Modifier
                    .background(color = colors.BLACK)
                    .padding(horizontal = 16.dp)
                    .wrapContentSize()
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                GolaroidLogo(
                    modifier = Modifier
                        .width(106.dp)
                        .height(23.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                GolaroidTextField(
                    placeholder = "코드를 입력해 주세요",
                    onValueChange = {
                    }, modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            SpanStyle(
                                fontFamily = pretendard,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = colors.WHITE
                            )
                        ) {
                            append("나만의 사진을\n")
                        }
                        withStyle(
                            SpanStyle(
                                fontFamily = pretendard,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = colors.WHITE
                            )
                        ) {
                            append("찍어 여러 종류의\n")
                        }

                        withStyle(
                            SpanStyle(
                                fontFamily = pretendard,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = colors.WHITE
                            )
                        ) {
                            append("프레임을 ")
                        }

                        withStyle(
                            SpanStyle(
                                fontFamily = pretendard,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = colors.MAIN
                            )
                        ) {
                            append("골라보세요")
                        }


                        withStyle(
                            SpanStyle(
                                fontFamily = pretendard,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = colors.WHITE
                            )
                        ) {
                            append("!!")
                        }
                    },
                    // modifier = Modifier.padding(start = 16.dp)
                )
            }

            Spacer(modifier = Modifier.height(3.dp))

            Row {
                StarIcon(modifier = Modifier.wrapContentSize().padding(start = 16.dp))
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "오늘의 사진보기",
                color = colors.WHITE,
                style = typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            PictureList()
        }
    }
}

@Composable
fun PictureList() {
    LazyRow(
        modifier = Modifier.wrapContentHeight(),
    ) {
        items(10) {
            Row {
                Spacer(modifier = Modifier.width(10.dp))

                PictureCard()
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPre() {
    MainScreen()
}