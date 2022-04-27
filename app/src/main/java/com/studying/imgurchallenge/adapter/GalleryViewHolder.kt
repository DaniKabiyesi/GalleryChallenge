package com.studying.imgurchallenge.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.studying.imgurchallenge.R

class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    //My ViewHolder to use in Adapter implementation
    val imageGallery: ImageView = itemView.findViewById(R.id.galleryListViewFirstLine)
}