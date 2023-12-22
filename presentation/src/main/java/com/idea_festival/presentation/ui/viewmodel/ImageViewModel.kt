package com.idea_festival.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.idea_festival.domain.usecase.image.UploadImageUseCase
import com.idea_festival.domain.usecase.image.UploadImageWithCodeUseCase
import javax.inject.Inject

class ImageViewModel @Inject constructor(
    private val uploadImageUseCase: UploadImageUseCase,
    private val uploadImageWithCodeUseCase: UploadImageWithCodeUseCase
) : ViewModel() {
    
}