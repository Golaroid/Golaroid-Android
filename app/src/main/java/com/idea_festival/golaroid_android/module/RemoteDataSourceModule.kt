package com.idea_festival.golaroid_android.module

import com.idea_festival.data.remote.datasource.ImageDataSource
import com.idea_festival.data.remote.datasource.ImageDataSourceImpl
import com.idea_festival.data.remote.datasource.PostDataSource
import com.idea_festival.data.remote.datasource.PostDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun bindImageDataSource(
        imageDataSourceImpl: ImageDataSourceImpl
    ): ImageDataSource

    @Binds
    abstract fun bindPostDataSource(
        postDataSourceImpl: PostDataSourceImpl
    ): PostDataSource
}