package com.idea_festival.data.remote.dto.image

import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody

data class ImageUploadWithCodeRequest(
    @SerializedName("images")
    val image: MultipartBody.Part,
    @SerializedName("isPublic")
    val isPublic: Boolean,
    @SerializedName("writer")
    val writer: String
)