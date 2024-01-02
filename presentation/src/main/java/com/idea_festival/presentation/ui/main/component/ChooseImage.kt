package com.idea_festival.presentation.ui.main.component

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.idea_festival.design_system.component.icon.CheckIcon
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.domain.model.post.GetDetailPostResponseModel
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel
import com.idea_festival.presentation.ui.viewmodel.ImageViewModel

@Composable
fun ChooseImage(
    modifier: Modifier = Modifier,
    image: Bitmap? = null,
    page: Int,
    imageViewModel: ImageViewModel
) {

    var selectedImage by remember { mutableStateOf<Bitmap?>(null) }

    GolaroidAndroidTheme { colors, typography ->
        Box(
            modifier = modifier
                .width(280.dp)
                .height(460.dp)
        ) {
            if (image != null) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(10.dp)),
                    bitmap = image.asImageBitmap(),
                    contentDescription = "Selected image",
                    contentScale = ContentScale.Crop
                )

            }

            IconButton(
                onClick = {
                    // 이거는 뒤에 나올 프린트를 위함이지 서버통신을 위한 저장이 아님
                    imageViewModel.setSelectedImage(image)
                },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                CheckIcon()
            }
        }
    }
}
