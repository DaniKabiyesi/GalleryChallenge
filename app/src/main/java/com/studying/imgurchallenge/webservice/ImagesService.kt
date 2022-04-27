package com.studying.imgurchallenge.webservice

import com.studying.imgurchallenge.model.DataResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ImagesService {
    @GET("/3/gallery/search/?")
    suspend fun getImage(
        @Header("Authorization") apiKey: String = "Client-ID 1ceddedc03a5d71",
        @Query("q") cats: String = "cats",
    ) : DataResponse

}