package com.studying.imgurchallenge.repositories

import com.studying.imgurchallenge.model.CatsImagesResponse
import com.studying.imgurchallenge.webservice.ImagesService
import java.lang.Exception

class GalleryRepository(private val retrofitService: ImagesService) : IGalleryRepository {
    override suspend fun getImage(link: String): CatsImagesResponse {

        try {
            return retrofitService.getImage(link)
        } catch (e: Exception) {
            throw e
        }
    }

}