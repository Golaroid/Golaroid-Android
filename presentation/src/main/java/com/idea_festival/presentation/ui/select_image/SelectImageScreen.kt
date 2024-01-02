package com.idea_festival.presentation.ui.select_image

import android.graphics.Bitmap
import android.util.Log
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.component.button.GolaroidButton
import com.idea_festival.design_system.component.icon.GoBackIcon
import com.idea_festival.design_system.component.image.ChooseImage
import com.idea_festival.design_system.theme.GolaroidAndroidTheme

@Composable
fun SelectImageRoute(
    onNextButtonClick: () -> Unit,
    imageArray: MutableList<Bitmap>?,
) {
    SelectImageScreen(
        onNextButtonClick = onNextButtonClick,
        imageArray = imageArray
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SelectImageScreen(
    onNextButtonClick: () -> Unit,
    imageArray: List<Bitmap>? = null,
) {
    val state = rememberPagerState {
        8
    }
    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = colors.BLACK)
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {

                Spacer(modifier = Modifier.width(16.dp))

                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    GoBackIcon()
                }

                Spacer(modifier = Modifier.width(43.dp))
                Text(
                    text = "4장의사진을 골라주세요!!",
                    style = typography.headlineSmall,
                    color = colors.WHITE
                )
            }

            Spacer(modifier = Modifier.height(74.dp))

            HorizontalPager(
                state = state,
                contentPadding = PaddingValues(horizontal = 40.dp)
            ) { page ->
                Log.e("imageArray", imageArray.toString())
                ChooseImage(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    image = imageArray?.get(page)
                )
            }

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

//@Preview
//@Composable
//fun SelectImageScreenPre() {
//    SelectImageScreen(
//        onNextButtonClick = {}
//    )
//}