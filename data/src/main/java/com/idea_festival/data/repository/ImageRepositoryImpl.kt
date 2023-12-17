package com.idea_festival.data.repository

import com.idea_festival.data.remote.datasource.ImageDataSource
import com.idea_festival.data.remote.dto.image.ImageUploadRequest
import com.idea_festival.data.remote.dto.image.ImageUploadWithCodeRequest
import com.idea_festival.domain.model.image.ImageUploadRequestModel
import com.idea_festival.domain.model.image.ImageUploadWithCodeRequestModel
import com.idea_festival.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageDataSource: ImageDataSource
) : ImageRepository {
    override suspend fun imageUpload(body: ImageUploadRequestModel): Flow<Unit> {
        return imageDataSource.uploadImage(
            body = ImageUploadRequest(
                image = body.image,
                isPublic = body.isPublic,
                writer = body.writer
            )
        )
    }

    override suspend fun imageUploadWithCode(body: ImageUploadWithCodeRequestModel): Flow<Unit> {
        return  imageDataSource.uploadImageWithCode(
            body = ImageUploadWithCodeRequest(
                images = body.images,
                isPublic = body.isPublic,
                writer = body.writer
            )
        )
    }
}