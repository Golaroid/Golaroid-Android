package com.idea_festival.data.remote.dto.post

import com.google.gson.annotations.SerializedName
import com.idea_festival.domain.model.post.GetDetailPostResponseModel

data class GetDetailPostResponse(
    @SerializedName("postId")
    val postId: Long,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("writer")
    val writer: String
)

fun GetDetailPostResponse.toModel(): GetDetailPostResponseModel {
    return GetDetailPostResponseModel(
        postId = this.postId,
        imageUrl = this.imageUrl,
        writer = this.writer
    )
}