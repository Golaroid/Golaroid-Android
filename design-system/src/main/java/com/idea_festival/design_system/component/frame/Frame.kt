package com.idea_festival.design_system.component.frame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.idea_festival.golaroid_android.design_system.R

@Composable
fun ChristmasFrame(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(480.dp)
            .background(color = Color(0xFF7F1A19))
    ) {

        Image(
            painter = painterResource(id = R.drawable.christmas_deco),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.Center)
                .zIndex(-1f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(362.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun RupeeFrame(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(480.dp)
            .background(color = Color(0xFFFFBABA))
    ) {
        Image(
            painter = painterResource(id = R.drawable.pink_logo),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 9.dp)
                .width(86.dp)
                .height(18.dp)
                .align(Alignment.TopCenter),
        )
        Image(
            painter = painterResource(id = R.drawable.roope_deco),
            contentDescription = null,
            modifier = Modifier.padding(top = 42.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.Center)
                .zIndex(-1f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.j1),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(362.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}


    @Composable
    fun GolaroidGrayFrame(
        modifier: Modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .width(320.dp)
                .height(480.dp)
                .background(color = Color(0xFF9C9C9C))
        ) {
            Image(
                painter = painterResource(id = R.drawable.gray_frame_golaroid_logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 9.dp)
                    .width(86.dp)
                    .height(18.dp)
                    .align(Alignment.TopCenter),
            )

            Image(
                painter = painterResource(id = R.drawable.na_deco),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.Center)
                    .zIndex(-1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.test_image_one_piece),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .height(362.dp)
                        .clip(shape = RoundedCornerShape(5.dp)),
                    contentScale = ContentScale.Crop
                )

            }
        }
    }

    @Composable
    fun GolaroidBlackFrame(
        modifier: Modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .width(320.dp)
                .height(480.dp)
                .background(color = Color(0xFF000000))
        ) {
            Image(
                painter = painterResource(id = R.drawable.black_frame_golaroid_logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 9.dp)
                    .width(86.dp)
                    .height(18.dp)
                    .align(Alignment.TopCenter),
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.Center)
                    .zIndex(-1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.test_image_one_piece),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .height(362.dp)
                        .clip(shape = RoundedCornerShape(5.dp)),
                    contentScale = ContentScale.Crop
                )


            }
        }
    }

@Preview
@Composable
fun FramePre() {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        ChristmasFrame()
    }
}