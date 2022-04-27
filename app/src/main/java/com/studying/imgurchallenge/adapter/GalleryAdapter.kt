package com.studying.imgurchallenge.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.studying.imgurchallenge.R
import com.studying.imgurchallenge.extensions.inflate
import com.studying.imgurchallenge.model.MyModel

class GalleryAdapter(
    private val list: List<MyModel>,
    private val context: Context,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //This is my adapter's implementation
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

    private fun bindItemViewHolder(viewHolder: GalleryViewHolder, entity: MyModel) {
        //Glide implementation
        Glide.with(context)
            .load(entity.myLink)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.placeholder_error)
            .into(viewHolder.imageGallery)
    }


}