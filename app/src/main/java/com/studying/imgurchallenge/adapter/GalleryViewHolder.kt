package com.studying.imgurchallenge.adapter

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.studying.imgurchallenge.R
import com.studying.imgurchallenge.model.Data

class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val imageGallery: ImageView = itemView.findViewById(R.id.galleryListViewFirstLine)
}