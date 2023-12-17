package com.idea_festival.data.remote.network

import com.idea_festival.data.remote.dto.post.GetDetailPostResponse
import com.idea_festival.data.remote.dto.post.GetPostResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PostAPI {
    @GET("post")
    suspend fun getPost(): GetPostResponse

    @GET("post/detail")
    suspend fun getDetailPost(
        @Query("code") code: String
    ): GetDetailPostResponse
}