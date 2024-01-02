package com.idea_festival.data.remote.datasource

import com.idea_festival.data.remote.dto.post.GetDetailPostResponse
import com.idea_festival.data.remote.dto.post.PostModel
import kotlinx.coroutines.flow.Flow

interface PostDataSource {
    suspend fun getPost(): Flow<List<PostModel>>
    suspend fun getDetailPost(code: String): Flow<List<GetDetailPostResponse>>
}