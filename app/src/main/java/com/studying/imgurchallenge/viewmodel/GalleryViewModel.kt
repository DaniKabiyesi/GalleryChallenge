package com.studying.imgurchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studying.imgurchallenge.model.Data
import com.studying.imgurchallenge.repositories.IGalleryRepository
import kotlinx.coroutines.launch

class GalleryViewModel(private val repository: IGalleryRepository) : ViewModel() {

    private val _catsImagesList = MutableLiveData<List<Data>>()
    val catsImagesList: LiveData<List<Data>> get() = _catsImagesList

    private val _catsImagesListErrorResponse = MutableLiveData<String>()
    val catsImagesListErrorResponse: LiveData<String> get() = _catsImagesListErrorResponse

    fun getImages(
    ) = viewModelScope.launch {
        try {
            val response = repository.getImage()
            _catsImagesList.postValue(response.data)
//            _catsImagesListErrorResponse.value = "test"
        } catch (error: Exception) {
            _catsImagesListErrorResponse.value = error.toString()
        }
    }

}