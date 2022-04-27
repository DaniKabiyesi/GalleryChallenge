package com.studying.imgurchallenge.repositories

import com.studying.imgurchallenge.model.DataResponse

interface IGalleryRepository {
    //Interface repository to improve view model structure
    suspend fun getImage () : DataResponse
}