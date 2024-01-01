package com.idea_festival.presentation.ui.capture

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.idea_festival.design_system.component.icon.WhiteCircleIcon
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.presentation.ui.capture.component.CameraPreview
import com.idea_festival.presentation.ui.capture.component.CheckPermission
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel
import kotlinx.coroutines.delay
import java.io.File
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.Executor
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


@Composable
fun CaptureRoute(
    onTakePictureFinish: () -> Unit,
    onBackClick: () -> Unit,
    viewModel: CameraViewModel = hiltViewModel(),
) {
    CaptureScreen(
        viewModel = viewModel,
        onTakePictureFinish = onTakePictureFinish,
        onBackClick = onBackClick,
        onInquiryCapture = {

        }
    )
}

@Composable
fun CaptureScreen(
    viewModel: CameraViewModel,
    onTakePictureFinish: () -> Unit,
    onBackClick: () -> Unit,
    onInquiryCapture: (ByteArray) -> Unit,
) {
    val imageArray: MutableList<Bitmap>? = mutableListOf()
    val context = LocalContext.current

    var countdownValue by remember { mutableIntStateOf(10) }
    var leftoverPictureValue by remember { mutableIntStateOf(8) }

    val lastCapturedPhoto: MutableState<Bitmap?> = remember { mutableStateOf(null) }

    var onCaptured by remember { mutableStateOf(false) }

    CheckPermission(context = context, viewModel = viewModel)

    GolaroidAndroidTheme { colors, typography ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            LaunchedEffect(countdownValue) {
                if (leftoverPictureValue > 0) {
                    delay(1000)
                    --countdownValue

                    if (countdownValue == 0) {
                        countdownValue = 10
                        --leftoverPictureValue
                        onCaptured = true
                    }
                } else if(leftoverPictureValue == 0) {
                    onTakePictureFinish()
                }
                onCaptured = false
            }

            CameraPreview(
                context = context,
                onPhotoCaptured = { captured ->
                    if (captured && viewModel.isInquiry.value) {
                        onInquiryCapture(viewModel.swapBitmapToJpeg())
                    } else if (onCaptured) {
                        lastCapturedPhoto.value?.let { imageArray?.add(it) }
                    }
                },
                onPhotoCapturedData = viewModel::loadImgBitmap,
                onCaptured = onCaptured
            )

            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "남은 사진 ${leftoverPictureValue}개",
                    style = typography.headlineSmall,
                    color = colors.WHITE,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(1f))



                Spacer(modifier = Modifier.weight(1f))


                Box {

                    WhiteCircleIcon(
                        modifier = Modifier
                            .width(49.dp)
                            .height(49.dp)
                            .padding()
                    )

                    Text(
                        text = "$countdownValue",
                        style = typography.titleSmall,
                        color = colors.WHITE,
                        modifier = Modifier.align(
                            Alignment.Center
                        )
                    )

                }

                Spacer(modifier = Modifier.width(16.dp))
            }

        }
    }
}