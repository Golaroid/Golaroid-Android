package com.idea_festival.data.remote.datasource

import com.idea_festival.data.remote.dto.post.GetDetailPostResponse
import com.idea_festival.data.remote.dto.post.PostModel
import com.idea_festival.data.remote.network.PostAPI
import com.idea_festival.data.util.GolaroidApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(
    private val service: PostAPI
) : PostDataSource {
    override suspend fun getPost(): Flow<List<PostModel>> = flow {
        emit(
            GolaroidApiHandler<List<PostModel>>()
                .httpRequest { service.getPost() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun getDetailPost(code: String): Flow<List<GetDetailPostResponse>> = flow {
        emit(
            GolaroidApiHandler<List<GetDetailPostResponse>>()
                .httpRequest { service.getDetailPost(code = code) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}