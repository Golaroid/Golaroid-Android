package com.idea_festival.data.remote.datasource

import com.idea_festival.data.remote.dto.image.ImageResponse
import com.idea_festival.data.remote.dto.image.ImageUploadRequest
import com.idea_festival.data.remote.dto.image.ImageUploadWithCodeRequest
import com.idea_festival.data.remote.network.ImageAPI
import com.idea_festival.data.util.GolaroidApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ImageDataSourceImpl @Inject constructor(
    private val service: ImageAPI
) : ImageDataSource {
    override suspend fun uploadImage(body: ImageUploadRequest): Flow<ImageResponse> = flow {
        emit(
            GolaroidApiHandler<ImageResponse>()
                .httpRequest { service.uploadImage(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun uploadImageWithCode(body: ImageUploadWithCodeRequest): Flow<ImageResponse> = flow {
        emit(
            GolaroidApiHandler<ImageResponse>()
                .httpRequest { service.uploadImageWithCode(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}