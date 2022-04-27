package com.studying.imgurchallenge.webservice

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class GalleryRetrofit {

    companion object {
        fun getGalleryRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.imgur.com")
                .addConverterFactory(GsonConverterFactory.create()).client(
                    OkHttpClient().newBuilder()
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(30, TimeUnit.SECONDS)
                        .build()
                )
                .build()
        }

        val create: ImagesService = getGalleryRetrofit().create(ImagesService::class.java)
    }
}