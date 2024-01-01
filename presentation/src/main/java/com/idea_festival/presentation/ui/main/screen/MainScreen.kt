package com.idea_festival.presentation.ui.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.idea_festival.design_system.component.button.GolaroidButton
import com.idea_festival.design_system.component.icon.OrangeCameraIcon
import com.idea_festival.design_system.component.icon.OrangeCircleIcon
import com.idea_festival.design_system.component.icon.StarIcon
import com.idea_festival.design_system.component.icon.StarfishStarIcon
import com.idea_festival.design_system.component.textfield.GolaroidTextField
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.design_system.theme.pretendard
import com.idea_festival.domain.model.post.GetPostResponseModel
import com.idea_festival.presentation.ui.main.component.AutoScrollingLazyRow
import com.idea_festival.presentation.ui.main.component.GolaroidLogo
import com.idea_festival.presentation.ui.viewmodel.PostViewModel
import com.idea_festival.presentation.ui.viewmodel.util.Event

@Composable
fun MainRoute(
    onTakePictureButtonClick: () -> Unit,
    onSearchButtonClick: () -> Unit,
    onImageClick: () -> Unit,
    postViewModel: PostViewModel = hiltViewModel(),
) {
    postViewModel.getPostList()
    LaunchedEffect(key1 = true) {
        getPostList(
            viewModel = postViewModel,
            onSuccess = {
                postViewModel.postList.value = it
            }
        )
    }
    MainScreen(
        onTakePictureButtonClick = onTakePictureButtonClick,
        onSearchButtonClick = onSearchButtonClick,
        onImageClick = {
            onImageClick()
            postViewModel.getDetailPostList(it)
        },
        items = postViewModel.postList.value!!
    )
}

suspend fun getPostList(
    viewModel: PostViewModel,
    onSuccess: (data: GetPostResponseModel) -> Unit
) {
    viewModel.getPostResponse.collect { response ->
        when (response) {
            is Event.Success -> {
                onSuccess(response.data!!)
            }

            else -> {}
        }
    }
}

@Composable
fun MainScreen(
    onTakePictureButtonClick: () -> Unit,
    onSearchButtonClick: () -> Unit,
    onImageClick: (String) -> Unit,
    items: GetPostResponseModel
) {
    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxSize()
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
                        .fillMaxWidth(),
                    onSearchButtonClick = { onSearchButtonClick() }
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            SpanStyle(
                                fontFamily = pretendard,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.6.sp,
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
                                letterSpacing = 0.6.sp,
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
                                letterSpacing = 0.6.sp,
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
                                letterSpacing = 0.6.sp,
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
                                letterSpacing = 0.6.sp,
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

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                StarIcon(
                    modifier = Modifier
                        .wrapContentSize()
                )

                Spacer(modifier = Modifier.weight(1f))

                OrangeCameraIcon(
                    modifier = Modifier
                        .wrapContentSize()
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "오늘의 사진보기",
                color = colors.WHITE,
                style = typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            AutoScrollingLazyRow(
                list = items.post,
                itemClicked = onImageClick
            )

            Spacer(modifier = Modifier.height(21.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                StarfishStarIcon(
                    modifier = Modifier
                        .wrapContentSize()
                )

                Spacer(modifier = Modifier.weight(1f))

                OrangeCircleIcon(
                    modifier = Modifier
                        .padding(top = 47.dp)
                        .wrapContentSize()
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            GolaroidButton(
                text = "사진찍기",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 16.dp)
            ) {
                onTakePictureButtonClick()
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}


@Preview
@Composable
fun MainScreenPre() {
    MainScreen(
        onTakePictureButtonClick = {},
        onSearchButtonClick = {},
        onImageClick = {},
        items = GetPostResponseModel(
            post = listOf(
                GetPostResponseModel.Post(
                    id = 1341513L,
                    writer = "채종인",
                    code = "A368SF",
                    imageUrl = ""
                )
            )
        )
    )
}