package com.studying.imgurchallenge.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GalleryRetrofit {

    companion object {
        fun getGalleryRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.imgur.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}