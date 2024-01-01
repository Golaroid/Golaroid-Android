package com.idea_festival.presentation.ui.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.idea_festival.design_system.component.button.GolaroidButton
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.domain.model.post.GetDetailPostResponseModel
import com.idea_festival.presentation.ui.viewmodel.PostViewModel
import com.idea_festival.presentation.ui.viewmodel.util.Event

@Composable
fun TodayImageRoute(
    onCheckButtonClick: () -> Unit,
    viewModel: PostViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        getPost(
            viewModel = viewModel,
            onSuccess = {
                viewModel.post.value = it
            }
        )
    }
    TodayImageScreen(
        onCheckButtonClick = onCheckButtonClick,
        data = viewModel.post.value
    )
}

suspend fun getPost(
    viewModel: PostViewModel,
    onSuccess: (data: GetDetailPostResponseModel) -> Unit
) {
    viewModel.getDetailPostResponse.collect { response ->
        when (response) {
            is Event.Success -> {
                onSuccess(response.data!!)
            }

            else -> {}
        }
    }
}

@Composable
fun TodayImageScreen(
    onCheckButtonClick: () -> Unit,
    data: GetDetailPostResponseModel
) {
    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = colors.BLACK)
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Row {
                Spacer(modifier = Modifier.weight(1f))
                AsyncImage(
                    model = data.imageUrl,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.weight(1f))

            }


            Spacer(modifier = Modifier.weight(1f))

            GolaroidButton(
                text = "확인", modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 36.dp)
            ) {
                onCheckButtonClick()
            }

        }
    }
}

@Preview
@Composable
fun TodayImageScreenPre() {
    TodayImageScreen(
        onCheckButtonClick = {},
        data = GetDetailPostResponseModel(
            postId = 5253L,
            imageUrl = "",
            writer = ""
        )
    )
}