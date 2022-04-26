package com.studying.imgurchallenge.repositories

import android.util.Log
import com.studying.imgurchallenge.model.DataResponse
import com.studying.imgurchallenge.webservice.ImagesService
import java.lang.Exception

class GalleryRepository(private val retrofitService: ImagesService) : IGalleryRepository {
    override suspend fun getImage(): DataResponse {

        Log.i("test", "entrou no repository")
        try { Log.i("test", "entrou no try")
            return retrofitService.getImage()
        } catch  (error: Exception) {
            Log.i("test", "entrou no catch")
             throw error

        }
    }

}