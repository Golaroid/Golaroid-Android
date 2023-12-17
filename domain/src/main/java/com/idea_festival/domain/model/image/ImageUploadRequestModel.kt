package com.idea_festival.domain.model.image

import okhttp3.MultipartBody

data class ImageUploadRequestModel(
    val image: MultipartBody.Part,
    val isPublic: Boolean,
    val writer: String
)
