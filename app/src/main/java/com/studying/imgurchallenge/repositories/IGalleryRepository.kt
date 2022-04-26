package com.studying.imgurchallenge.repositories

import com.studying.imgurchallenge.model.DataResponse

interface IGalleryRepository {
    suspend fun getImage () : DataResponse
}