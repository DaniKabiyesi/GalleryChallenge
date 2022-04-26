package com.studying.imgurchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.studying.imgurchallenge.repositories.GalleryRepository
import com.studying.imgurchallenge.webservice.GalleryRetrofit

class GalleryViewModelFactory() : ViewModelProvider.Factory {

    private val retrofitService = GalleryRetrofit.getGalleryRetrofit()

    override fun <T : ViewModel> create(modelClass: Class<T>) : T {
        return if (modelClass.isAssignableFrom(GalleryViewModel::class.java)){
            val repository = GalleryRepository(retrofitService)
            GalleryViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}