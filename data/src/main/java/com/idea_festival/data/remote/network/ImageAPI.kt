package com.idea_festival.data.remote.network

import com.idea_festival.data.remote.dto.image.ImageUploadRequest
import com.idea_festival.data.remote.dto.image.ImageUploadWithCodeRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ImageAPI {
    @POST("image")
    suspend fun uploadImage(
        @Body body: ImageUploadRequest
    )

    @POST("image/snap-shot")
    suspend fun uploadImageWithCode(
        @Body body: ImageUploadWithCodeRequest
    )
}