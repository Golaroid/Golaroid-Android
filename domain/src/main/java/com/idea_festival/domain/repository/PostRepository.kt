package com.idea_festival.domain.repository

import com.idea_festival.domain.model.post.GetDetailPostResponseModel
import com.idea_festival.domain.model.post.GetPostResponseModel
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPost(): Flow<GetPostResponseModel>
    suspend fun getDetailPost(code: String): Flow<GetDetailPostResponseModel>
}