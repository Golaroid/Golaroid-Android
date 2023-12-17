package com.idea_festival.domain.usecase.image

import com.idea_festival.domain.model.image.ImageUploadRequestModel
import com.idea_festival.domain.repository.ImageRepository
import javax.inject.Inject

class UploadImageUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(body: ImageUploadRequestModel) = runCatching {
        repository.imageUpload(body = body)
    }
}