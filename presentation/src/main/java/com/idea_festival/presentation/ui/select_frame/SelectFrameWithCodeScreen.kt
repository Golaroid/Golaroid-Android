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
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.presentation.ui.select_frame.component.WithCodeChristmasFrame
import com.idea_festival.presentation.ui.select_frame.component.WithCodeGolaroidBlackFrame
import com.idea_festival.presentation.ui.select_frame.component.WithCodeGolaroidGrayFrame
import com.idea_festival.presentation.ui.select_frame.component.WithCodeRupeeFrame
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel
import com.idea_festival.presentation.ui.viewmodel.PostViewModel

@Composable
fun SelectFrameWithCodeRoute(
    onPrintButtonClick: () -> Unit,
    onNextButtonClick: () -> Unit,
    cameraViewModel: CameraViewModel,
    postViewModel: PostViewModel
) {
    SelectFrameScreen(
        onPrintButtonClick = onPrintButtonClick,
        onNextButtonClick = onNextButtonClick,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SelectFrameWithCodeScreen(
    onPrintButtonClick: () -> Unit,
    onNextButtonClick: () -> Unit,
    postViewModel: PostViewModel
) {
    val pagerState = rememberPagerState(pageCount = { 6 })
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

                when (page) {

                    0 -> WithCodeChristmasFrame(viewModel = postViewModel)

                    1 -> WithCodeRupeeFrame(viewModel = postViewModel)

                    2 -> WithCodeGolaroidGrayFrame(viewModel = postViewModel)

                    3 -> WithCodeGolaroidBlackFrame(viewModel = postViewModel)

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
                    onNextButtonClick()
                }

            }
        }
    }
}
