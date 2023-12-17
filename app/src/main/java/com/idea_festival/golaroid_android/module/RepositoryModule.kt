package com.idea_festival.golaroid_android.module

import com.idea_festival.data.repository.ImageRepositoryImpl
import com.idea_festival.data.repository.PostRepositoryImpl
import com.idea_festival.domain.repository.ImageRepository
import com.idea_festival.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindImageRepository(
        imageRepositoryImpl: ImageRepositoryImpl
    ): ImageRepository

    @Binds
    abstract fun bindPostRepository(
        postRepositoryImpl: PostRepositoryImpl
    ): PostRepository
}