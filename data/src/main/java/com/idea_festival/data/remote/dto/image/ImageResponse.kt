package com.idea_festival.data.remote.dto.image

import com.google.gson.annotations.SerializedName
import com.idea_festival.domain.model.image.ImageResponseModel

data class ImageResponse(
    @SerializedName("fileName")
    val fileName: String,
)

fun ImageResponse.toModel(): ImageResponseModel {
    return ImageResponseModel(
        fileName = fileName
    )
}
