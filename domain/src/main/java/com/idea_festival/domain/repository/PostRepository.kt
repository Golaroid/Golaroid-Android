package com.idea_festival.domain.repository

import com.idea_festival.domain.model.post.GetDetailPostResponseModel
import com.idea_festival.domain.model.post.PostModel
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPost(): Flow<List<PostModel>>
    suspend fun getDetailPost(code: String): Flow<List<GetDetailPostResponseModel>>
}