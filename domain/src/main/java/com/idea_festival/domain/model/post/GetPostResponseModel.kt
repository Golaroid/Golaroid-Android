package com.idea_festival.domain.model.post

data class GetPostResponseModel(
    val post: List<Post>
) {
    data class Post(
        val id: Long,
        val writer: String,
        val code: String,
        val imageUrl: String
    )
}
