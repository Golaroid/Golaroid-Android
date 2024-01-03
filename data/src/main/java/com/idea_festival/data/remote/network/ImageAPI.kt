package com.idea_festival.data.remote.network

import com.idea_festival.data.remote.dto.image.ImageResponse
import com.idea_festival.data.remote.dto.image.ImageUploadRequest
import com.idea_festival.data.remote.dto.image.ImageUploadWithCodeRequest
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ImageAPI {
    @Multipart
    @POST("image")
    suspend fun uploadImage(
        @Part body: MultipartBody.Part,
        ): ImageResponse

    @POST("image/snap-shot")
    suspend fun uploadImageWithCode(
        @Body body: ImageUploadWithCodeRequest,
    ): ImageResponse
}