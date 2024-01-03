package com.idea_festival.domain.usecase.image

import com.idea_festival.domain.model.image.ImageUploadRequestModel
import com.idea_festival.domain.repository.ImageRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class UploadImageUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(body: MultipartBody.Part) = runCatching {
        repository.imageUpload(body = body)
    }
}