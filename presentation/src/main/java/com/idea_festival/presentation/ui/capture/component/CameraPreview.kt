package com.idea_festival.presentation.ui.capture.component

import android.content.Context
import android.graphics.Bitmap
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import com.idea_festival.presentation.ui.util.capturePhoto
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import java.io.File

@Composable
fun CameraPreview(
    context: Context,
    onPhotoCapturedData: (Bitmap) -> Unit,
    onPhotoCaptured: (Boolean) -> Unit,
    onCaptured: Boolean,
) {

    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    val cameraController: LifecycleCameraController = remember { LifecycleCameraController(context) }

    GolaroidAndroidTheme { colors, typography ->
        Scaffold(
            modifier = Modifier.fillMaxSize(),
        ) { innerPadding: PaddingValues ->
            if (onCaptured) {
                capturePhoto(
                    context = context,
                    cameraController = cameraController,
                    onPhotoCaptured = { captured -> onPhotoCaptured(captured) },
                    onPhotoCapturedData = { bitmap -> onPhotoCapturedData(bitmap) },
                )
            }
            AndroidView(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                factory = { context ->
                    PreviewView(context).apply {
                        setBackgroundColor(colors.BLACK.toArgb())
                        layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                        scaleType = PreviewView.ScaleType.FILL_CENTER
                        implementationMode = PreviewView.ImplementationMode.COMPATIBLE
                    }.also { previewView ->
                        previewView.controller = cameraController
                        cameraController.bindToLifecycle(lifecycleOwner)
                    }
                },
                onRelease = {
                    cameraController.unbind()
                })
        }
    }
}