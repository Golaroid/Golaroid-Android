package com.idea_festival.data.remote.network

import com.idea_festival.data.remote.dto.post.GetDetailPostResponse
import com.idea_festival.data.remote.dto.post.PostModel
import retrofit2.http.GET
import retrofit2.http.Query

interface PostAPI {
    @GET("post")
    suspend fun getPost(): List<PostModel>

    @GET("post/detail")
    suspend fun getDetailPost(
        @Query("code") code: String
    ): List<GetDetailPostResponse>
}