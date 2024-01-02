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

@Composable
fun ChooseImage(
    modifier: Modifier = Modifier,
    image: Bitmap? = null,
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

            }

            IconButton(
                onClick = { },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                CheckIcon()
            }
        }
    }
}
