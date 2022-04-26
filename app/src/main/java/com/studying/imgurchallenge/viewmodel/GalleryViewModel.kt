package com.studying.imgurchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studying.imgurchallenge.model.CatsImagesResponse
import com.studying.imgurchallenge.repositories.IGalleryRepository
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class GalleryViewModel(private val repository: IGalleryRepository) : ViewModel() {

    private val _catsImagesList = MutableLiveData<CatsImagesResponse>()
    val catsImagesList: LiveData<CatsImagesResponse> get() = _catsImagesList

    private val _catsImagesListErrorResponse = MutableLiveData<String>()
    val catsImagesListErrorResponse: LiveData<String> get() = _catsImagesListErrorResponse

    fun getCatsImages(
        link: String,
    ) = viewModelScope.launch {
        try {
            val response = repository.getImage(link)
            _catsImagesList.value = response
        } catch (error: Exception) {
            _catsImagesListErrorResponse.value = error.toString()
        }

    }

}