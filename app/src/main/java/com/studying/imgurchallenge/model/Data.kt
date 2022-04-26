package com.studying.imgurchallenge.model

import android.media.Image

data class Data(
    val id: String,
    val title: String,
    val link: String,
    val images: List<com.studying.imgurchallenge.model.Image>,
)
