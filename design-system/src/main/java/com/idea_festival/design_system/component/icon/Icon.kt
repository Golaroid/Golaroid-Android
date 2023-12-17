package com.idea_festival.design_system.component.icon

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.idea_festival.golaroid_android.design_system.R

@Composable
fun SearchIcon(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_search),
        contentDescription = "검색 버튼 돋보기 아이콘",
        modifier = modifier
    )
}

@Composable
fun StarIcon(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_star),
        contentDescription = "백그라운드용 핑크 별 아이콘",
        modifier = modifier
    )
}

@Composable
fun StarfishStarIcon(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_starfish_star),
        contentDescription = "백그라운드용 메인컬러 별 아이콘",
        modifier = modifier
    )
}


@Composable
fun OrangeCircleIcon(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_orange_circle),
        contentDescription = "백그라운드용 오렌지 원 아이콘",
        modifier = modifier
    )
}

@Composable
fun OrangeCameraIcon(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_orange_camera),
        contentDescription = "백그라운드용 오렌지 카메라 아이콘",
        modifier = modifier
    )
}

@Composable
fun ClipboardIcon(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_clipboard),
        contentDescription = "클립보드 복사 아이콘",
        modifier = modifier
    )
}