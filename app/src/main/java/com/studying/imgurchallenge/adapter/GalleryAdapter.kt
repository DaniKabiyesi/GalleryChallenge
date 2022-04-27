package com.studying.imgurchallenge.adapter

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.studying.imgurchallenge.R
import com.studying.imgurchallenge.extensions.inflate
import com.studying.imgurchallenge.model.Data

class GalleryAdapter(
    private val list: List<Data>,
    private val context: Context,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

//    private var galleryList: List<MyModel> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerView.ViewHolder {
        val view = parent.inflate(R.layout.gallery_list)
        return GalleryViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as GalleryViewHolder
        val entity = list[position]
        bindItemViewHolder(itemViewHolder, entity)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun bindItemViewHolder(viewHolder: GalleryViewHolder, entity: Data) {
        Log.i("test", "${entity.link}")
        Glide.with(context)
            .load("https://i.imgur.com/Qc6nmvb.jpg")
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(viewHolder.imageGallery)

    }


}