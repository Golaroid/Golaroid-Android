package com.idea_festival.design_system.component.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
fun GoBackIcon(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_go_back),
        contentDescription = "돌아가기 아이콘",
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
            .width(24.dp)
            .height(24.dp)
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

@Composable
fun PurpleStickIcon(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_purple_stick),
        contentDescription = "기울어진 보라색 막대",
        modifier = modifier
    )
}

@Composable
fun CutPinkStarIcon(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_cut_pink_star),
        contentDescription = "잘린 StarIcon",
        modifier = modifier
    )
}

@Composable
fun UnCutOrangeCameraIcon(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_un_cut_orange_camera),
        contentDescription = "전체 오렌지 카메라 아이콘",
        modifier = modifier
    )
}

@Composable
fun GreenStarIcon(
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(id = R.drawable.ic_green_star),
        contentDescription = "기울어진 형광 별 아이콘",
        modifier = modifier
    )
}