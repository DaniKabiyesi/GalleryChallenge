package com.studying.imgurchallenge.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

//I use this method to inflate view in Adapter
fun ViewGroup.inflate(@LayoutRes layoutRes: Int) : View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)

}