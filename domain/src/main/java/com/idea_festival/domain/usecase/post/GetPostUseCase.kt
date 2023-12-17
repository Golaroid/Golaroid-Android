package com.idea_festival.domain.usecase.post

import com.idea_festival.domain.repository.PostRepository
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke() = runCatching {
        repository.getPost()
    }
}