package com.studying.imgurchallenge.repositories

import com.studying.imgurchallenge.model.CatsImagesResponse

interface IGalleryRepository {
    suspend fun getImage (link: String) : CatsImagesResponse
}