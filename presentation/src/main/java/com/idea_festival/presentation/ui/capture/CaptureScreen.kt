@file:JvmName("CaptureScreenKt")

package com.idea_festival.presentation.ui.capture

import android.graphics.Bitmap
import androidx.camera.core.CameraSelector
import androidx.compose.foundation.clickable
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
import com.idea_festival.design_system.component.icon.SwitchCameraIcon
import com.idea_festival.design_system.component.icon.WhiteCircleIcon
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.presentation.ui.capture.component.CameraPreview
import com.idea_festival.presentation.ui.capture.component.CheckPermission
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel
import kotlinx.coroutines.delay


@Composable
fun CaptureRoute(
    onTakePictureFinish: () -> Unit,
    onBackClick: () -> Unit,
    cameraViewModel: CameraViewModel,
) {
    CaptureScreen(
        viewModel = cameraViewModel,
        onTakePictureFinish = onTakePictureFinish,
        onBackClick = onBackClick,
    )
}


@Composable
fun CaptureScreen(
    viewModel: CameraViewModel,
    onTakePictureFinish: () -> Unit,
    onBackClick: () -> Unit,
) {

    var lensFacing by remember { mutableStateOf(CameraSelector.DEFAULT_FRONT_CAMERA) }

    val imageArray: MutableList<Bitmap> = mutableListOf()
    val context = LocalContext.current

    var countdownValue by remember { mutableIntStateOf(2) }
    var leftoverPictureValue by remember { mutableIntStateOf(4) }

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
                        countdownValue = 2
                        --leftoverPictureValue
                        onCaptured = true
                    }
                } else if (leftoverPictureValue == 0) {
                    onTakePictureFinish()
                }
            }


            CameraPreview(
                context = context,
                onPhotoCapturedData = {
                    viewModel.loadImgBitmap(it)
                    lastCapturedPhoto.value = it
                },
                onPhotoCaptured = { captured ->
                    onCaptured = false
                    lastCapturedPhoto.value?.let { imageArray?.add(it) }
                    viewModel.setImageArray(imageArray)
                },
                onCaptured = onCaptured,
            )

            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            ) {

                Spacer(modifier = Modifier.width(16.dp))

                SwitchCameraIcon(
                    modifier = Modifier
                        .clickable {
                            lensFacing =
                                if (lensFacing == CameraSelector.DEFAULT_FRONT_CAMERA) CameraSelector.DEFAULT_BACK_CAMERA
                                else CameraSelector.DEFAULT_FRONT_CAMERA
                            viewModel.toggleCameraFacing()
                        }
                        .width(24.dp)
                        .height(24.dp)
                )

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