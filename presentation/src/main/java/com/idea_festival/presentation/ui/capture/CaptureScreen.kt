package com.idea_festival.presentation.ui.capture

import android.content.Context
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberPermissionState
import com.idea_festival.design_system.component.icon.WhiteCircleIcon
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.ujizin.camposer.CameraPreview
import com.ujizin.camposer.state.rememberCameraState
import java.io.File


private fun Context.createNewFile(extension: String) = File(
    filesDir, "${System.currentTimeMillis()}.$extension"
).apply { createNewFile() }

@Composable
fun CaptureRoute(
    onBackClick: () -> Unit,
) {
    CaptureScreen(onBackClick = onBackClick)
}

@Composable
fun CaptureScreen(
    onBackClick: () -> Unit,
) {
    val cameraPermissionState: PermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)

    GolaroidAndroidTheme { colors, typography ->

            CameraPreview(
                modifier = Modifier.fillMaxSize(),
                cameraState = cameraState
            ) {

            }
//            Row(
//                modifier = Modifier
//                    .padding(top = 30.dp)
//                    .fillMaxWidth()
//                    .align(Alignment.TopCenter)
//            ) {
//                Spacer(modifier = Modifier.weight(1f))
//                Spacer(modifier = Modifier.weight(1f))
//
//
//                Text(
//                    text = "남은 사진 " + "n개",
//                    style = typography.headlineSmall,
//                    color = colors.WHITE,
//                    modifier = Modifier.align(Alignment.CenterVertically)
//                )
//
//                Spacer(modifier = Modifier.weight(1f))
//
//                Box {
//
//                    WhiteCircleIcon(
//                        modifier = Modifier
//                            .width(49.dp)
//                            .height(49.dp)
//                            .padding()
//                    )
//
//                    Text(
//                        text = "10",
//                        style = typography.titleSmall,
//                        color = colors.WHITE,
//                        modifier = Modifier.align(
//                            Alignment.Center
//                        )
//                    )
//
//                }
//
//                Spacer(modifier = Modifier.width(16.dp))
//
//            }
        }

    }

@Preview
@Composable
fun CaptureScreenPre() {
    CaptureScreen(onBackClick = {})
}
