package com.idea_festival.presentation.ui.viewmodel

import com.idea_festival.golaroid_android.design_system.R
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idea_festival.domain.model.image.ImageResponseModel
import com.idea_festival.domain.model.image.ImageUploadRequestModel
import com.idea_festival.domain.model.image.ImageUploadWithCodeRequestModel
import com.idea_festival.domain.usecase.image.UploadImageUseCase
import com.idea_festival.domain.usecase.image.UploadImageWithCodeUseCase
import com.idea_festival.presentation.ui.capture.CaptureState
import com.idea_festival.presentation.ui.util.Event
import com.idea_festival.presentation.ui.util.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
    private val uploadImageWithCodeUseCase: UploadImageWithCodeUseCase,
) : ViewModel() {

    val _facing = MutableStateFlow(CameraSelector.LENS_FACING_BACK)

    private val _capturedImgBitmapState = MutableStateFlow(CaptureState())
    val captureImgBitmapState = _capturedImgBitmapState.asStateFlow()

    private val _defaultImageBitmap = MutableStateFlow(CaptureState())
    val defaultImageBitmap = _defaultImageBitmap.asStateFlow()


    private val _uploadImageRequest = MutableLiveData<Event<ImageResponseModel>>()
    val uploadImageRequest: LiveData<Event<ImageResponseModel>> get() = _uploadImageRequest


    private val _uploadImageWithRequest = MutableLiveData<Event<ImageResponseModel>>()
    val uploadImageWithRequest: LiveData<Event<ImageResponseModel>> get() = _uploadImageWithRequest

    var isInquiry = mutableStateOf(false)

    private val _imageArray = MutableStateFlow<MutableList<Bitmap>>(mutableListOf())
    val imageArray: StateFlow<MutableList<Bitmap>> get() = _imageArray

    fun setImageArray(imageArray: MutableList<Bitmap>) {
        _imageArray.value = imageArray
    }

    fun loadImgBitmap(bitmap: Bitmap) {
        viewModelScope.launch {
            _capturedImgBitmapState.value.capturedImage?.recycle()
            _capturedImgBitmapState.value = _capturedImgBitmapState.value.copy(capturedImage = bitmap)
        }
    }

    fun getMultipartFile(context: Context, isDefault: Boolean): MultipartBody.Part {
        val fileName = "capturedImage.jpg"
        val mediaType = "image/jpeg"
        val byteArray = if (isDefault) {
            _defaultImageBitmap.value.capturedImage?.recycle()
            _defaultImageBitmap.value = _defaultImageBitmap.value.copy(
                capturedImage = getBitmapFromDrawableResourceId(
                    context = context,
                    drawableResId = R.drawable.ic_logo

                )
            )
            swapBitmapToJpegWithMultipartFile(true).toRequestBody(mediaType.toMediaType())
        } else {
            swapBitmapToJpegWithMultipartFile(false).toRequestBody(mediaType.toMediaType())
        }

        return MultipartBody.Part.createFormData("golaroid", fileName, byteArray)
    }


    fun swapBitmapToJpeg(): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()

        val swapBitmap = _capturedImgBitmapState.value.capturedImage

        swapBitmap?.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream)

        return byteArrayOutputStream.toByteArray()
    }


    private fun swapBitmapToJpegWithMultipartFile(isDefault: Boolean): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()

        val swapBitmap = if (isDefault) {
            _defaultImageBitmap.value.capturedImage
        } else {
            _capturedImgBitmapState.value.capturedImage
        }

        swapBitmap?.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)

        return byteArrayOutputStream.toByteArray()
    }

    private fun getBitmapFromDrawableResourceId(context: Context, drawableResId: Int): Bitmap {
        val drawable = ContextCompat.getDrawable(context, drawableResId)
            ?: throw IllegalArgumentException("Invalid drawable resource ID")

        return drawableToBitmap(drawable)
    }


    private fun drawableToBitmap(drawable: Drawable): Bitmap {
        if (drawable is BitmapDrawable) {
            return drawable.bitmap
        }

        val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)

        return bitmap
    }

    fun toggleCameraFacing() {
        Log.e("스위칭", "스위치 함수 실행")
        if (_facing.value == CameraSelector.LENS_FACING_BACK) {
            _facing.value = CameraSelector.LENS_FACING_FRONT
        } else {
            _facing.value = CameraSelector.LENS_FACING_BACK
        }
    }


    fun uploadImage(body: ImageUploadRequestModel) = viewModelScope.launch {
        uploadImageUseCase(
            body = body
        ).onSuccess {
            it.catch { remoteError ->
                _uploadImageRequest.value = remoteError.errorHandling()
            }.collect { response ->
                _uploadImageRequest.value = Event.Success(data = response)
            }
        }.onFailure {
            _uploadImageRequest.value = it.errorHandling()
        }
    }

    fun uploadImageWithCode(body: ImageUploadWithCodeRequestModel) = viewModelScope.launch {
        uploadImageWithCodeUseCase(
            body = body
        ).onSuccess {
            it.catch { remoteError ->
                _uploadImageWithRequest.value = remoteError.errorHandling()
            }.collect { response ->
                _uploadImageWithRequest.value = Event.Success(data = response)
            }
        }.onFailure {
            _uploadImageWithRequest.value = it.errorHandling()
        }
    }
}