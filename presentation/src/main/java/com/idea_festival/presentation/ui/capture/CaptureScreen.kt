package com.idea_festival.presentation.ui.capture

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.view.LifecycleCameraController
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
import androidx.core.net.toFile
import androidx.hilt.navigation.compose.hiltViewModel
import com.idea_festival.design_system.component.icon.WhiteCircleIcon
import com.idea_festival.design_system.theme.GolaroidAndroidTheme
import com.idea_festival.presentation.ui.capture.component.CameraPreview
import com.idea_festival.presentation.ui.capture.component.CheckPermission
import com.idea_festival.presentation.ui.viewmodel.CameraViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.concurrent.Executor


private fun Context.createNewFile(extension: String) = File(
    filesDir, "${System.currentTimeMillis()}.$extension"
).apply { createNewFile() }

@Composable
fun CaptureRoute(
    onTakePictureFinish: () -> Unit,
    onBackClick: () -> Unit,
    viewModel: CameraViewModel = hiltViewModel(),
) {
    CaptureScreen(
        onBackClick = onBackClick,
        viewModel = viewModel,
        onTakePictureFinish = onTakePictureFinish,
        onInquiryCapture = {},
        onCaptured = true
    )
}

@Composable
fun CaptureScreen(
    viewModel: CameraViewModel,
    onTakePictureFinish: () -> Unit,
    onInquiryCapture: (ByteArray) -> Unit,
    onBackClick: () -> Unit,
    onCaptured: Boolean
) {
    val imageArray: MutableList<Bitmap>? = mutableListOf()
    val context = LocalContext.current
    var countdownValue by remember { mutableIntStateOf(10) }
    var leftoverPictureValue by remember { mutableIntStateOf(8) }
    val lastCapturedPhoto: MutableState<Bitmap?> = remember { mutableStateOf(null) }

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
                        onTakePictureFinish()
                    }
                }
            }


            CameraPreview(
                context = context,
                onPhotoCaptured = { captured ->
                    if (captured && viewModel.isInquiry.value) {
                        onInquiryCapture(viewModel.swapBitmapToJpeg())
                    }
                    else if (onCaptured) {
                        lastCapturedPhoto.value?.let { imageArray?.add(it) }
                    }
                },
                onPhotoCapturedData = viewModel::loadImgBitmap,
                onCaptured = true
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

private suspend fun saveBitmapToMediaStore(imageFile: File?, context: Context): Uri? {
    return withContext(Dispatchers.IO) {
        if (imageFile == null) {
            return@withContext null
        }

        val contentValues = ContentValues().apply {
            put(
                MediaStore.Images.Media.DISPLAY_NAME,
                "captured_image_${System.currentTimeMillis()}.jpg"
            )
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
        }

        val resolver = context.contentResolver
        var outputStream: OutputStream? = null
        var uri: Uri? = null

        try {
            val contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            val contentUriResult = resolver.insert(contentUri, contentValues)

            if (contentUriResult != null) {
                outputStream = resolver.openOutputStream(contentUriResult)
                if (outputStream != null) {
                    // Read the bitmap from the file and compress it
                    val bitmap = BitmapFactory.decodeFile(imageFile.absolutePath)
                    bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                    uri = contentUriResult
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            outputStream?.close()
        }

        return@withContext uri
    }
}

fun capturePhoto(
    context: Context,
    cameraController: LifecycleCameraController,
): File? {
    val mainExecutor: Executor = ContextCompat.getMainExecutor(context)

    var capturedFile: File? = null

    cameraController.takePicture(mainExecutor, object : ImageCapture.OnImageCapturedCallback() {
        override fun onCaptureSuccess(image: ImageProxy) {
            val correctedBitmap: Bitmap = image
                .toBitmap()
                .rotateBitmap(image.imageInfo.rotationDegrees)

            // Save the bitmap to a file
            capturedFile = saveBitmapToFile(correctedBitmap, context)

            image.close()
        }

        override fun onError(exception: ImageCaptureException) {
            // Handle error
        }
    })

    return capturedFile
}

fun saveBitmapToFile(bitmap: Bitmap, context: Context): File {
    val imageFile = context.createNewFile("jpg")

    val stream = FileOutputStream(imageFile)
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
    stream.flush()
    stream.close()

    return imageFile
}

fun Bitmap.rotateBitmap(rotationDegrees: Int): Bitmap {
    val matrix = Matrix().apply {
        postRotate(-rotationDegrees.toFloat())
        postScale(-1f, -1f)
    }

    return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
}
