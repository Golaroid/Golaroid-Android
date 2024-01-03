package com.idea_festival.data.remote.dto.image

import com.google.gson.annotations.SerializedName
import com.idea_festival.domain.model.image.ImageUploadRequestModel
import okhttp3.MultipartBody
import okhttp3.RequestBody

data class ImageUploadRequest(
    @SerializedName("image")
    val image: MultipartBody.Part,
)
