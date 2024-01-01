package com.idea_festival.presentation.ui.viewmodel

import android.graphics.Bitmap
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idea_festival.domain.model.image.ImageUploadRequestModel
import com.idea_festival.domain.model.image.ImageUploadWithCodeRequestModel
import com.idea_festival.domain.usecase.image.UploadImageUseCase
import com.idea_festival.domain.usecase.image.UploadImageWithCodeUseCase
import com.idea_festival.presentation.ui.capture.CameraState
import com.idea_festival.presentation.ui.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(
    private val uploadImageUseCase: UploadImageUseCase,
    private val uploadImageWithCodeUseCase: UploadImageWithCodeUseCase
) : ViewModel() {
    private val _capturedImgBitmapState = MutableStateFlow(CameraState())
    val captureImgBitmapState = _capturedImgBitmapState.asStateFlow()

    private val _uploadImageRequest = MutableLiveData<Event<>>()
    val uploadImageRequest: LiveData<Event>
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

    fun uploadImage(body: ImageUploadRequestModel) = viewModelScope.launch {
            uploadImageUseCase(
                body = body
            ).onSuccess {
                it.catch { remoteError ->

                }
            }
    }

    fun uploadImageWithCode(body: ImageUploadWithCodeRequestModel) = viewModelScope.launch {
        val multipartFile = getMultipartFile()

        try {
            uploadImageWithCodeUseCase()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}