package com.idea_festival.presentation.ui.check_image.screen

import android.graphics.Bitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.idea_festival.design_system.component.button.GolaroidButton
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.presentation.ui.viewmodel.ImageViewModel


@Composable
fun CheckImageScreen(
    imageViewModel: ImageViewModel
) {
    GolaroidAndroidTheme { colors, typography ->
        Box(
            modifier = Modifier
                .background(color = colors.BLACK)
                .fillMaxSize()
        ) {
            AsyncImage(
                model = imageViewModel.selectedImage,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.Center)
            )

            GolaroidButton(
                text = "메인으로 가기",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 36.dp)
            ) {
            }
        }
    }
}
