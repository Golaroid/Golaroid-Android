package com.idea_festival.presentation.ui.main.component

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.runtime.setValue
import com.idea_festival.domain.model.post.PostModel

@Composable
fun PictureLazyRow(
    data: List<PostModel>,
    onClick: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier.wrapContentHeight(),
    ) {
        items(data) {
            Spacer(modifier = Modifier.width(10.dp))

            PictureCard(
                data = it,
                onClick = onClick
            )
        }
    }
}

private const val SCROLL_DX = 24f
private const val REQUIRED_CARD_COUNT = 8

private class AutoScrollItem<T>(
    val data: T
)

@Composable
fun AutoScrollingLazyRow(
    list: List<PostModel>,
    modifier: Modifier = Modifier,
    itemClicked: (String) -> Unit
) {
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    var items by remember { mutableStateOf(list.mapAutoScrollItem()) }

    LazyRow(
        state = lazyListState,
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(
            items, key = { _, item -> item }
        ) { index, item ->
            PictureCard(data = item.data, onClick = itemClicked)

            Spacer(modifier = Modifier.width(10.dp))

            if (index == items.lastIndex) {
                val currentList = items
                val firstVisibleItemIndex = lazyListState.firstVisibleItemIndex
                val secondPart = currentList.subList(0, firstVisibleItemIndex)
                val firstPart =
                    currentList.subList(firstVisibleItemIndex, currentList.size)

                LaunchedEffect(key1 = Unit) {
                    coroutineScope.launch {
                        lazyListState.scrollToItem(
                            0,
                            maxOf(
                                0,
                                lazyListState.firstVisibleItemScrollOffset - SCROLL_DX.toInt()
                            )
                        )
                    }
                }

                items = (firstPart + secondPart)
            }
        }
    }
    LaunchedEffect(key1 = Unit) {
        coroutineScope.launch {
            while (true) {
                lazyListState.autoScroll()
            }
        }
    }
}

private fun List<PostModel>.mapAutoScrollItem(): List<AutoScrollItem<PostModel>> {
    val newList = this.map { AutoScrollItem(data = it) }.toMutableList()
    var index = 0
    if (this.size < REQUIRED_CARD_COUNT) {
        while (newList.size != REQUIRED_CARD_COUNT) {
            if (index > this.size - 1) {
                index = 0
            }

            newList.add(AutoScrollItem(data = this[index]))
            index++
        }
    }
    return newList
}

suspend fun ScrollableState.autoScroll(
    animationSpec: AnimationSpec<Float> = tween(durationMillis = 800, easing = LinearEasing),
) {
    var previousValue = 0f
    scroll(MutatePriority.PreventUserInput) {
        animate(0f, SCROLL_DX, animationSpec = animationSpec) { currentValue, _ ->
            previousValue += scrollBy(currentValue - previousValue)
        }
    }
}