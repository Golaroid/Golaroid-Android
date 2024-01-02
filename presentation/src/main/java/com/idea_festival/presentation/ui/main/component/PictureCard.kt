package com.idea_festival.presentation.ui.main.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.domain.model.post.PostModel

@Composable
fun PictureCard(
    data: PostModel,
    onClick: (String) -> Unit
) {
    GolaroidAndroidTheme { colors, typography ->
        Box(
            modifier = Modifier
                .width(140.dp)
                .height(180.dp)
                .clickable(onClick = { onClick(data.code) })
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp)),
                model = data.imageUrl,
                contentDescription = "test image",
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                ImageCodeText(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(top = 148.dp, start = 42.dp, bottom = 6.dp, end = 6.dp),
                    writer = data.writer,
                    code = data.code
                )
            }
        }
    }
}

@Preview
@Composable
fun PictureCardPre() {
    PictureCard(
        data = PostModel(
            id = 1493853L,
            writer = "채종인",
            code = "F239AS",
            imageUrl = ""
        ),
        onClick = {}
    )
}