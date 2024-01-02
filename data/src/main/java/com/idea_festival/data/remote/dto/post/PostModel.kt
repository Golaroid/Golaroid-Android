package com.idea_festival.data.remote.dto.post

import com.google.gson.annotations.SerializedName
import com.idea_festival.domain.model.post.PostModel as domainPostModel

data class PostModel(
    @SerializedName("id")
    val id: Long,
    @SerializedName("writer")
    val writer: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("imageUrl")
    val imageUrl: String
)

fun PostModel.toModel(): domainPostModel {
    return domainPostModel(
        id = this.id,
        writer = this.writer,
        code = this.code,
        imageUrl = this.imageUrl
    )
}