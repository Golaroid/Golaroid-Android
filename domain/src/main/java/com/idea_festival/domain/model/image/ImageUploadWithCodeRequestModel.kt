package com.idea_festival.domain.model.image

import okhttp3.MultipartBody

data class ImageUploadWithCodeRequestModel(
    val image: MultipartBody.Part,
    val isPublic: Boolean,
    val writer: String
)
