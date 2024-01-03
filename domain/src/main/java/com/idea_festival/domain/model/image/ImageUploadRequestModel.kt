package com.idea_festival.domain.model.image

import okhttp3.MultipartBody

data class ImageUploadRequestModel(
    val image: MultipartBody.Part,
    val request: Request
) {
    data class Request(
        val isPublic: Boolean,
        val writer: String
    )
}