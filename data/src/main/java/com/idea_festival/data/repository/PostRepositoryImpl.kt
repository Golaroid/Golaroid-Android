package com.idea_festival.data.repository

import com.idea_festival.data.remote.datasource.PostDataSource
import com.idea_festival.data.remote.dto.post.toModel
import com.idea_festival.domain.model.post.GetDetailPostResponseModel
import com.idea_festival.domain.model.post.GetPostResponseModel
import com.idea_festival.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val dataSource: PostDataSource
) : PostRepository {
    override suspend fun getPost(): Flow<GetPostResponseModel> {
        return dataSource.getPost().map { it.toModel() }
    }

    override suspend fun getDetailPost(code: String): Flow<GetDetailPostResponseModel> {
        return dataSource.getDetailPost(
            code = code
        ).map { it.toModel() }
    }
}