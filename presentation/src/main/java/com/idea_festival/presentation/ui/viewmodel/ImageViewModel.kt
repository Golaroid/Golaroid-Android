package com.idea_festival.presentation.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idea_festival.domain.model.image.ImageResponseModel
import com.idea_festival.domain.model.image.ImageUploadRequestModel
import com.idea_festival.domain.model.image.ImageUploadWithCodeRequestModel
import com.idea_festival.domain.usecase.image.UploadImageUseCase
import com.idea_festival.domain.usecase.image.UploadImageWithCodeUseCase
import com.idea_festival.presentation.ui.viewmodel.util.Event
import com.idea_festival.presentation.ui.viewmodel.util.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    private val uploadImageUseCase: UploadImageUseCase,
    private val uploadImageWithCodeUseCase: UploadImageWithCodeUseCase
) : ViewModel() {

    private val _uploadImageResponse = MutableStateFlow<Event<ImageResponseModel>>(Event.Loading)
    val uploadImageResponse = _uploadImageResponse.asStateFlow()

    private val _uploadImageWithCodeResponse = MutableStateFlow<Event<ImageResponseModel>>(Event.Loading)
    val uploadImageWithCodeResponse = _uploadImageWithCodeResponse

    var uploadImage = mutableStateOf<ImageUploadRequestModel?>(null)
        private set

    var uploadImageWithCode = mutableStateOf<ImageUploadWithCodeRequestModel?>(null)
        private set

    fun upload() = viewModelScope.launch {
        uploadImage.value?.let { image ->
            uploadImageUseCase(
                body = image
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

    fun uploadWithCode() = viewModelScope.launch {
        uploadImageWithCode.value?.let { image ->
            uploadImageWithCodeUseCase(
                body = image
            ).onSuccess {
                it.catch { remoteError ->
                    _uploadImageWithCodeResponse.value = remoteError.errorHandling()
                }.collect { response ->
                    _uploadImageWithCodeResponse.value = Event.Success(data = response)
                }
            }.onFailure { error ->
                _uploadImageWithCodeResponse.value = error.errorHandling()
            }
        }
    }

    fun setImage(
        image: ImageUploadRequestModel
    ) {
        uploadImage.value = image
    }

    fun setImageWithCode(
        image: ImageUploadWithCodeRequestModel
    ) {
        uploadImageWithCode.value = image
    }
}