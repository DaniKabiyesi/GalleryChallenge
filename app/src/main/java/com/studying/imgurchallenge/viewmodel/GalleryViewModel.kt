package com.studying.imgurchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studying.imgurchallenge.model.MyModel
import com.studying.imgurchallenge.repositories.IGalleryRepository
import kotlinx.coroutines.launch

//This ViewModel is designed to store and manage UI
class GalleryViewModel(private val repository: IGalleryRepository) : ViewModel() {

    //MutableLiveData and LiveData variables
    private val _catsImagesList = MutableLiveData<List<MyModel>>()
    val catsImagesList: LiveData<List<MyModel>> get() = _catsImagesList

    private val _catsImagesListErrorResponse = MutableLiveData<String>()
    val catsImagesListErrorResponse: LiveData<String> get() = _catsImagesListErrorResponse

    fun getImages(
    ) = viewModelScope.launch {
        //Response from getImage() with CoroutinesScope implementation
        try {
            val response = repository.getImage()
            val myModel = response.data.map { data ->
                //Validation to get a nullable value or data images
                if (data.images?.get(0)?.link?.isEmpty() == true) {
                    MyModel(
                        myLink = ""
                    )
                } else {
                    MyModel(
                        myLink = data.images?.get(0)?.link
                    )
                }
            }
            _catsImagesList.postValue(myModel)
        } catch (error: Exception) {
            //Response from getImage() with message error
            _catsImagesListErrorResponse.value = error.toString()
        }
    }

}