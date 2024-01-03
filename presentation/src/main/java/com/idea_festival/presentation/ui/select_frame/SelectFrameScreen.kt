package com.idea_festival.presentation.ui.select_frame

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.component.button.GolaroidButton
import com.idea_festival.presentation.ui.select_frame.component.ChristmasFrame
import com.idea_festival.presentation.ui.select_frame.component.GolaroidBlackFrame
import com.idea_festival.presentation.ui.select_frame.component.GolaroidGrayFrame
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.presentation.ui.select_frame.component.CodeRupeeFrame
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel
import com.idea_festival.presentation.ui.viewmodel.ImageViewModel
import com.smarttoolfactory.screenshot.ScreenshotBox
import com.smarttoolfactory.screenshot.rememberScreenshotState

@Composable
fun SelectFrameRoute(
    onPrintButtonClick: () -> Unit,
    onNextButtonClick: () -> Unit,
    cameraViewModel: CameraViewModel,
    imageViewModel: ImageViewModel,
    ) {
    SelectFrameScreen(
        onPrintButtonClick = onPrintButtonClick,
        onNextButtonClick = onNextButtonClick,
        imageViewModel = imageViewModel
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SelectFrameScreen(
    onPrintButtonClick: () -> Unit,
    onNextButtonClick: () -> Unit,
    imageViewModel: ImageViewModel,

    ) {
    val pagerState = rememberPagerState(pageCount = { 9 })

    val screenshotStateList = listOf(
        rememberScreenshotState(),
        rememberScreenshotState(),
        rememberScreenshotState(),
        rememberScreenshotState()
    )

    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = colors.BLACK)
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            HorizontalPager(
                contentPadding = PaddingValues(horizontal = 15.dp),
                state = pagerState
            ) { page ->
                ScreenshotBox(screenshotState = screenshotStateList[page]) {
                    when (page) {

                        0 -> ChristmasFrame(
                            imageViewModel = imageViewModel,
                        )

                        1 -> CodeRupeeFrame(
                            imageViewModel = imageViewModel
                        )

                        2 -> GolaroidGrayFrame(
                            imageViewModel = imageViewModel
                        )

                        3 -> GolaroidBlackFrame(
                            imageViewModel = imageViewModel
                        )

                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .padding(bottom = 36.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                GolaroidButton(text = "출력하기", modifier = Modifier.weight(1f)) {
                    onPrintButtonClick()
                }

                Spacer(modifier = Modifier.width(20.dp))

                GolaroidButton(text = "넘어가기", modifier = Modifier.weight(1f)) {
                    with(screenshotStateList[pagerState.currentPage]) {
                        capture()
                        imageBitmap?.let {
                            imageViewModel.setSelectedImageWithFrame(it)
                            onNextButtonClick()
                        }
                    }
                }

            }
        }
    }
}
