package com.idea_festival.presentation.ui.search_result.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idea_festival.design_system.component.button.GolaroidButton
import com.idea_festival.design_system.component.icon.ClipboardIcon
import com.idea_festival.design_system.component.icon.GoBackIcon
import com.idea_festival.design_system.component.tobar.GoBackTopBar
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.domain.model.post.GetDetailPostResponseModel
import com.idea_festival.presentation.ui.viewmodel.PostViewModel
import com.idea_festival.presentation.ui.viewmodel.util.Event

@Composable
fun ExistCodeRoute(
    onTakePictureWithCodeButtonClick: () -> Unit,
    onBackClick: () -> Unit,
    onNotFound: () -> Unit,
    postViewModel: PostViewModel,
) {
    val status = remember{ mutableStateOf(false) }
    LaunchedEffect(true) {
        getPost(
            viewModel = postViewModel,
            onSuccess = {
                postViewModel.post.value = it
            },
            onNotFound = onNotFound,
            onFinished = {
                status.value = it
            }
        )
    }
    if (status.value) {
        postViewModel.withCode.value = true
        ExistCodeScreen(
            onTakePictureWithCodeButtonClick = onTakePictureWithCodeButtonClick,
            onBackClick = onBackClick,
            code = postViewModel.savedCode.value,
            writer = postViewModel.post.value.writer
        )
    }
}

suspend fun getPost(
    viewModel: PostViewModel,
    onSuccess: (data: GetDetailPostResponseModel) -> Unit,
    onNotFound: () -> Unit,
    onFinished: (isSuccess: Boolean) -> Unit
) {
    viewModel.getDetailPostResponse.collect { response ->
        when (response) {
            is Event.Success -> {
                onSuccess(response.data!!)
                onFinished(true)
            }
            is Event.NotFound -> {
                onNotFound()
                onFinished(false)
            }
            else -> {
                onFinished(false)
            }
        }
    }
}

@Composable
fun ExistCodeScreen(
    onTakePictureWithCodeButtonClick: () -> Unit,
    onBackClick: () -> Unit,
    code: String,
    writer: String
) {
    GolaroidAndroidTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = colors.BLACK)
        ) {
            Spacer(modifier = Modifier.height(22.dp))

            GoBackTopBar(
                icon = { (GoBackIcon()) },
                text = "뒤로가기"
            ) {
                onBackClick()
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = code,
                    style = typography.headlineSmall,
                    color = colors.WHITE,
                )

                Spacer(modifier = Modifier.width(14.dp))

                ClipboardIcon(modifier = Modifier.padding(top = 4.dp))

                Spacer(modifier = Modifier.weight(1f))

            }

            Spacer(modifier = Modifier.height(151.dp))

            Text(
                text = "${writer}님과",
                style = typography.headlineMedium,
                color = colors.WHITE,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = "같이 사진찍기",
                style = typography.headlineMedium,
                color = colors.WHITE,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.weight(1f))

            GolaroidButton(
                text = "사진찍기",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 36.dp)
            ) {
                onTakePictureWithCodeButtonClick()
            }
        }
    }
}

@Preview
@Composable
fun ExistCodeScreenPre() {
    ExistCodeScreen(
        onTakePictureWithCodeButtonClick = {},
        onBackClick = {},
        code = "",
        writer = ""
    )
}