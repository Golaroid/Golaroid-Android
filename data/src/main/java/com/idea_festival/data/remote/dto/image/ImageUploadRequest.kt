package com.idea_festival.data.remote.dto.image

import com.google.gson.annotations.SerializedName
import com.idea_festival.domain.model.image.ImageUploadRequestModel
import okhttp3.MultipartBody

data class ImageUploadRequest(
    @SerializedName("image")
    val image: MultipartBody.Part,
    @SerializedName("request")
    val request: ImageUploadRequestModel.Request
)
