package com.idea_festival.data.remote.dto.image

import com.google.gson.annotations.SerializedName
import com.idea_festival.domain.model.image.ImageUploadWithCodeRequestModel
import okhttp3.MultipartBody

data class ImageUploadWithCodeRequest(
    @SerializedName("images")
    val image: MultipartBody.Part,
    @SerializedName("request")
    val request: ImageUploadWithCodeRequestModel.Request
)