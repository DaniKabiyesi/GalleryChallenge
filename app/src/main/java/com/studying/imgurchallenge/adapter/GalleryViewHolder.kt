package com.studying.imgurchallenge.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.studying.imgurchallenge.R

class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val galleryList: ImageView = itemView.findViewById<ImageView>(R.id.galleryListCardView)
}