package com.idea_festival.presentation.ui.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.golaroid_android.presentation.R

@Composable
fun PictureCard() {
    GolaroidAndroidTheme { colors, typography ->
        Box(
            modifier = Modifier
                .wrapContentSize()
        ) {
            Image(
                modifier = Modifier
                    .width(140.dp)
                    .height(180.dp)
                    .clip(RoundedCornerShape(10.dp)),
                painter = painterResource(id = com.idea_festival.golaroid_android.design_system.R.drawable.test_image),
                contentDescription = "test image",
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun PictureCardPre() {
    PictureCard()
}