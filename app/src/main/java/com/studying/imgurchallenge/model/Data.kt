package com.studying.imgurchallenge.model

import android.media.Image

data class Data(
    //Data model to receive Api request
    val id: String,
    val title: String,
    val link: String,
    val images: List<com.studying.imgurchallenge.model.Image>? = null,
)
