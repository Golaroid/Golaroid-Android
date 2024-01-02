package com.idea_festival.presentation.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idea_festival.domain.model.post.GetDetailPostResponseModel
import com.idea_festival.domain.model.post.PostModel
import com.idea_festival.domain.usecase.post.GetDetailPostUseCase
import com.idea_festival.domain.usecase.post.GetPostUseCase
import com.idea_festival.presentation.ui.viewmodel.util.Event
import com.idea_festival.presentation.ui.viewmodel.util.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase,
    private val getDetailPostUseCase: GetDetailPostUseCase
) : ViewModel() {

    private val _getPostResponse = MutableStateFlow<Event<List<PostModel>>>(Event.Loading)
    val getPostResponse = _getPostResponse.asStateFlow()

    private val _getDetailPostResponse = MutableStateFlow<Event<GetDetailPostResponseModel>>(Event.Loading)
    val getDetailPostResponse = _getDetailPostResponse

    var postList = mutableStateListOf<PostModel>()
        private set

    var post = mutableStateOf(
        GetDetailPostResponseModel(
            postId = 0L,
            imageUrl = "",
            writer = ""
        )
    )

    var savedCode = mutableStateOf("")
        private set

    var withCode = mutableStateOf(false)
        private set

    fun getPostList() = viewModelScope.launch {
        getPostUseCase().onSuccess {
            it.catch { remoteError ->
                _getPostResponse.value = remoteError.errorHandling()
            }.collect { response ->
                _getPostResponse.value = Event.Success(data = response)
            }
        }.onFailure { error ->
            _getPostResponse.value = error.errorHandling()
        }
    }

    fun getDetailPostList(
        code: String
    ) = viewModelScope.launch {
        savedCode.value = code
        getDetailPostUseCase(code = code).onSuccess {
            it.catch { remoteError ->
                _getDetailPostResponse.value = remoteError.errorHandling()
            }.collect { response ->
                _getDetailPostResponse.value = Event.Success(data = response)
            }
        }.onFailure { error ->
            _getDetailPostResponse.value = error.errorHandling()
        }
    }
}