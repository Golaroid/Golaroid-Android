package com.idea_festival.domain.usecase.image

import com.idea_festival.domain.model.image.ImageUploadWithCodeRequestModel
import com.idea_festival.domain.repository.ImageRepository
import javax.inject.Inject

class UploadImageWithCodeUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(body: ImageUploadWithCodeRequestModel) = runCatching {
        repository.imageUploadWithCode(body = body)
    }
}