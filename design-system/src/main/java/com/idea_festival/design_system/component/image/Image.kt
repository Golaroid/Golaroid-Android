package com.idea_festival.design_system.component.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.component.icon.CheckIcon
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.golaroid_android.design_system.R

@Composable
fun ChooseImage(
    modifier: Modifier = Modifier
) {
    GolaroidAndroidTheme { colors, typography ->
        Box(
            modifier = modifier
                .width(280.dp)
                .height(460.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                painter = painterResource(id = R.drawable.test_image),
                contentDescription = "test image",
                contentScale = ContentScale.Crop
            )

            IconButton(
                onClick = { },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                CheckIcon()
            }
        }
    }
}

@Preview
@Composable
fun ChooseImagePre() {
    ChooseImage()
}