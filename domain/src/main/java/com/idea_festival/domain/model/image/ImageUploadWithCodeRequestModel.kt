package com.idea_festival.domain.model.image

import okhttp3.MultipartBody

data class ImageUploadWithCodeRequestModel(
    val images: List<MultipartBody.Part>,
    val isPublic: Boolean,
    val writer: String
)
