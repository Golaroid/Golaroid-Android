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
import com.idea_festival.domain.model.post.GetDetailPostResponseModel
import com.idea_festival.domain.usecase.image.UploadImageUseCase
import com.idea_festival.domain.usecase.image.UploadImageWithCodeUseCase
import com.idea_festival.presentation.ui.capture.CaptureState
import com.idea_festival.presentation.ui.capture.DetailPostData
import com.idea_festival.presentation.ui.viewmodel.util.Event
import com.idea_festival.presentation.ui.viewmodel.util.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.parse
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
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

    private val _uploadImageResponse = MutableStateFlow<Event<ImageResponseModel>>(Event.Loading)
    val uploadImageResponse = _uploadImageResponse.asStateFlow()

    private val _uploadImageWithCodeResponse = MutableStateFlow<Event<ImageResponseModel>>(Event.Loading)
    val uploadImageWithCodeResponse = _uploadImageWithCodeResponse

    var isPublic = mutableStateOf<Boolean?>(null)
        private set

    var userName = mutableStateOf("")
        private set

    var selectedImage = mutableStateOf<MultipartBody.Part?>(null)
        private set

    private var uploadImage = mutableStateOf<ImageUploadRequestModel?>(null)

    private var uploadImageWithCode = mutableStateOf<ImageUploadWithCodeRequestModel?>(null)

    var issuedCode = mutableStateOf("")
        private set

    fun setImageArray(imageArray: MutableList<Bitmap>) {
        _imageArray.value = imageArray
    }

    fun loadImgBitmap(bitmap: Bitmap) {
        viewModelScope.launch {
      //      _capturedImgBitmapState.value.capturedImage?.recycle()
            _capturedImgBitmapState.value = _capturedImgBitmapState.value.copy(capturedImage = bitmap)
        }
    }

    fun getMultipartFile(context: Context, isDefault: Boolean, selectedIndex: Int) {
        val fileName = "image.jpeg"
        val mediaType = "image/jpeg"
        val byteArray = if (isDefault) {
            _defaultImageBitmap.value.capturedImage?.recycle()
            _defaultImageBitmap.value = _defaultImageBitmap.value.copy(
                capturedImage = getBitmapFromDrawableResourceId(
                    context = context,
                    drawableResId = R.drawable.ic_logo
                )
            )
            swapBitmapToJpegWithMultipartFile(imageArray.value[selectedIndex],true).toRequestBody(mediaType.toMediaType())
        } else {
            swapBitmapToJpegWithMultipartFile(imageArray.value[selectedIndex],false).toRequestBody(mediaType.toMediaType())
        }

        selectedImage.value = MultipartBody.Part.createFormData("image", fileName, byteArray)
    }


    fun swapBitmapToJpeg(): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()

        val swapBitmap = _capturedImgBitmapState.value.capturedImage

        swapBitmap?.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream)

        return byteArrayOutputStream.toByteArray()
    }


    private fun swapBitmapToJpegWithMultipartFile(selectedImage: Bitmap, isDefault: Boolean): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()

        val swapBitmap = if (isDefault) {
            _defaultImageBitmap.value.capturedImage
        } else {
            selectedImage
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
            Log.e("facing값", _facing.value.toString())
        } else {
            _facing.value = CameraSelector.LENS_FACING_BACK
            Log.e("facing값", _facing.value.toString())
        }
    }

    fun upload() = viewModelScope.launch {
        val isPublicBody = RequestBody.create("text/plain".toMediaTypeOrNull(), isPublic.toString())
        val userNameBody = RequestBody.create("text/plain".toMediaTypeOrNull(), userName.value)
        val requestMap: HashMap<String, RequestBody> = HashMap()
        requestMap["isPublic"] = isPublicBody
        requestMap["writer"] = userNameBody
        selectedImage.value?.let {
            uploadImageUseCase(
                body = it
            ).onSuccess {
                it.catch { remoteError ->
                    _uploadImageResponse.value = remoteError.errorHandling()
                }.collect { response ->
                    _uploadImageResponse.value = Event.Success(data = response)
                }
            }.onFailure { error ->
                _uploadImageResponse.value = error.errorHandling()
            }
        }
        }

    }

//    fun uploadWithCode() = viewModelScope.launch {
//        uploadImageWithCode.value?.let { image ->
//            uploadImageWithCodeUseCase(
//                body = image
//            ).onSuccess {
//                it.catch { remoteError ->
//                    _uploadImageWithCodeResponse.value = remoteError.errorHandling()
//                }.collect { response ->
//                    _uploadImageWithCodeResponse.value = Event.Success(data = response)
//                }
//            }.onFailure { error ->
//                _uploadImageWithCodeResponse.value = error.errorHandling()
//            }
//        }
//    }

