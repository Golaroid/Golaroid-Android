package com.idea_festival.domain.model.post

data class GetDetailPostResponseModel(
    val postId: Long,
    val imageUrl: String,
    val writer: String
)
