package com.idea_festival.domain.repository

import com.idea_festival.domain.model.image.ImageResponseModel
import com.idea_festival.domain.model.image.ImageUploadRequestModel
import com.idea_festival.domain.model.image.ImageUploadWithCodeRequestModel
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody

interface ImageRepository {
    suspend fun imageUpload(body: MultipartBody.Part): Flow<ImageResponseModel>
    suspend fun imageUploadWithCode(body: ImageUploadWithCodeRequestModel): Flow<ImageResponseModel>
}