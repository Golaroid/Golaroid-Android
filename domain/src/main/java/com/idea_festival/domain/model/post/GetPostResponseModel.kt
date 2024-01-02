package com.idea_festival.domain.model.post

data class PostModel(
    val id: Long,
    val writer: String,
    val code: String,
    val imageUrl: String
)
