package com.idea_festival.presentation.ui.select_image.component

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.idea_festival.design_system.component.icon.CheckIcon
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.presentation.ui.viewmodel.ImageViewModel
import com.idea_festival.presentation.ui.viewmodel.PostViewModel

@Composable
fun ChooseImageWithCode(
    modifier: Modifier = Modifier,
    image: Bitmap? = null,
    postViewModel: PostViewModel,
    imageViewModel: ImageViewModel,
    imageArray: MutableList<Bitmap>,
    page: Int
) {
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

                AsyncImage(
                    model = postViewModel.getDetailPostResponse.value.data?.imageUrl.toString(),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                )
            }


            IconButton(
                onClick = {
                    imageViewModel.setSelectedImage(image)
                },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                CheckIcon()
            }
        }
    }
}