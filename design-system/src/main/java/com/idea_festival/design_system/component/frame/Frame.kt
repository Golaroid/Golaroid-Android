package com.idea_festival.design_system.component.frame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.idea_festival.golaroid_android.design_system.R

@Composable
fun ChristmasFrame() {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(600.dp)
            .background(color = Color(0xFF7F1A19))
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_santa_sleigh),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 80.dp)
                .zIndex(-1f)
                .width(114.dp)
                .height(51.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.christmas_frame_decoration),
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
                    .padding(top = 37.dp, bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(120.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun RupeeFrame() {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(600.dp)
            .background(color = Color(0xFFFFBABA))
    ) {
        Image(
            painter = painterResource(id = R.drawable.rupee_frame_decoration),
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
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 37.dp, bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(120.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun WinterFrame() {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(600.dp)
            .background(color = Color(0xFFD3E7FF))
    ) {
        Image(
            painter = painterResource(id = R.drawable.winter_frame_decoration),
            contentDescription = null,
            modifier = Modifier.padding(top = 21.dp)
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
                    .padding(top = 37.dp, bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(120.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun WantedFrame() {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(600.dp)
            .background(color = Color(0xFFEBD4BE))
            .border(width = 4.dp, color = Color(0xFF55463C))
    ) {
        Image(
            painter = painterResource(id = R.drawable.wanted_frame_decoration),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 14.dp, bottom = 10.dp)
                .align(Alignment.TopCenter)
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
                    .padding(top = 37.dp, bottom = 7.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(120.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun PangPangFrame() {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(600.dp)
            .background(color = Color(0xFF9AC860))
    ) {
        Image(
            painter = painterResource(id = R.drawable.pang_pang_frame_decoration),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 37.dp)
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
                    .padding(top = 37.dp, bottom = 7.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(120.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
                    .clip(shape = RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.test_image_one_piece),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .height(115.dp)
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
        PangPangFrame()
    }
}