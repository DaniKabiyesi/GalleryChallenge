package com.studying.imgurchallenge.repositories

import android.util.Log
import com.studying.imgurchallenge.model.DataResponse
import com.studying.imgurchallenge.webservice.ImagesService
import java.lang.Exception

class GalleryRepository(private val retrofitService: ImagesService) : IGalleryRepository {
    override suspend fun getImage(): DataResponse {

        //Repository to get images from DataResponse

        try {
            return retrofitService.getImage()
        } catch  (error: Exception) {
             throw error
        }
    }

}