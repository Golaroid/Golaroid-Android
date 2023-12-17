package com.idea_festival.domain.usecase.post

import com.idea_festival.domain.repository.PostRepository
import javax.inject.Inject

class GetDetailPostUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke(code: String) = runCatching {
        repository.getDetailPost(code = code)
    }
}