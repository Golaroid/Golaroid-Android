package com.idea_festival.data.remote.datasource

import com.idea_festival.data.remote.dto.post.GetDetailPostResponse
import com.idea_festival.data.remote.dto.post.GetPostResponse
import kotlinx.coroutines.flow.Flow

interface PostDataSource {
    suspend fun getPost(): Flow<GetPostResponse>
    suspend fun getDetailPost(code: String): Flow<GetDetailPostResponse>
}