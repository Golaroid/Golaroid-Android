package com.idea_festival.data.remote.dto.post

import com.google.gson.annotations.SerializedName
import com.idea_festival.domain.model.post.GetPostResponseModel

data class GetPostResponse(
    val post: List<Post>
) {
    data class Post(
        @SerializedName("id")
        val id: Long,
        @SerializedName("writer")
        val writer: String,
        @SerializedName("code")
        val code: String,
        @SerializedName("imageUrl")
        val imageUrl: String
    )

    fun Post.toModel(): GetPostResponseModel.Post {
        return GetPostResponseModel.Post(
            id = this.id,
            writer = this.writer,
            code = this.code,
            imageUrl = this.imageUrl
        )
    }
}

fun GetPostResponse.toModel(): GetPostResponseModel {
    return GetPostResponseModel(post = this.post.map { it.toModel() })
}