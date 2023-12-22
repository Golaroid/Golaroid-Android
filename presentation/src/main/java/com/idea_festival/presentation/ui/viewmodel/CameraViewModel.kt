package com.idea_festival.presentation.ui.viewmodel

import android.graphics.Bitmap
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idea_festival.presentation.ui.capture.CameraState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(
) : ViewModel() {
    private val _capturedImgBitmapState = MutableStateFlow(CameraState())
    val captureImgBitmapState = _capturedImgBitmapState.asStateFlow()

    var isInquiry = mutableStateOf(false)

    fun loadImgBitmap(bitmap: Bitmap) = viewModelScope.launch {
        _capturedImgBitmapState.value.capturedImage?.recycle()
        _capturedImgBitmapState.value = _capturedImgBitmapState.value.copy(capturedImage = bitmap)
    }

    fun getBitmap(): ImageBitmap? {
        (captureImgBitmapState.value.capturedImage?.asImageBitmap() ?: null)?.let {
            return it
        }
        return null
    }

    fun getMultipartFile(): MultipartBody.Part {
        val fileName = "capturedImage.jpg"
        val mediaType = "image/jpeg"
        val byteArray = swapBitmapToJpegWithMultipartFile().toRequestBody(mediaType.toMediaType())

        return MultipartBody.Part.createFormData("recyclables", fileName, byteArray)
    }

    private fun swapBitmapToJpegWithMultipartFile(): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()

        val swapBitmap = _capturedImgBitmapState.value.capturedImage

        swapBitmap?.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)

        return byteArrayOutputStream.toByteArray()
    }

    fun swapBitmapToJpeg(): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()

        val swapBitmap = _capturedImgBitmapState.value.capturedImage

        swapBitmap?.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream)

        return byteArrayOutputStream.toByteArray()
    }
}