package com.idea_festival.data.remote.datasource

import com.idea_festival.data.remote.dto.image.ImageResponse
import com.idea_festival.data.remote.dto.image.ImageUploadRequest
import com.idea_festival.data.remote.dto.image.ImageUploadWithCodeRequest
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import retrofit2.http.Multipart

interface ImageDataSource {
    suspend fun uploadImage(body: MultipartBody.Part): Flow<ImageResponse>
    suspend fun uploadImageWithCode(body: ImageUploadWithCodeRequest): Flow<ImageResponse>
}